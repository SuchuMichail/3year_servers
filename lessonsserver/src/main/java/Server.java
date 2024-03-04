import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import handlers.IHandler;
import repositories.DataBase;
import responses.IntermediateResp;
import responses.ResponseEntity;
import handlers.student_handlers.*;
import services.IStudentService;
import services.StudentService;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Server {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private DataBase base;
    private final Map<String, IHandler> map;

    public Server(DataBase base){
        this.base = base;
        map = new HashMap<>();
        init();
    }

    public void setBase(DataBase base) {
        this.base = base;
    }

    private void addEndpointAndHandler(String endpoint, IHandler handler){
        //в маппе endpoint сопоставляется хэндлеру.
        map.put(endpoint, handler);
    }

    private void init(){
        IStudentService service = new StudentService(base);
        StudentController controller = new StudentController(service);
        addEndpointAndHandler("addStudent",new AddStudentHandler(controller));
        addEndpointAndHandler("deleteStudent",new DeleteStudentHandler(controller));
        addEndpointAndHandler("editStudent",new EditStudentHandler(controller));
        addEndpointAndHandler("getStudentById",new GetStudentByIdHandler(controller));
        addEndpointAndHandler("getStudentsByGroup",new GetStudentsByGroupHandler(controller));
    }

    public String getResponse(String endpoint, String json) throws Exception {
        try{
            return (map.get(endpoint)).handle(json);
        }catch (JsonProcessingException e) {
            return "Bad request";
        }catch (Exception e){
            return "500";
        }
    }
}
