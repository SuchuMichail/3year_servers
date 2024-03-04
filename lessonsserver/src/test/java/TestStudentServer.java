import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import repositories.DataBase;
import requests.students.*;

public class TestStudentServer {
    ObjectMapper objectMapper = new ObjectMapper();

    DataBase dataBase = new DataBase();
    Server server = new Server(dataBase);

    @Test
    public void TestAddStudentNorm() throws Exception {
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "Last",
                "First",
                "Middle",
                104,
                "OK");
        String json = objectMapper.writeValueAsString(addStudentRequest);
        String response = server.getResponse("addStudent",json);
        String expectedJson = "{\"response\":{\"response\":{\"id\":1},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(response,expectedJson);
    }

    @Test
    public void TestAddStudentNullName() throws Exception {
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                null,
                "First",
                "Middle",
                102,
                "OK");
        String json = objectMapper.writeValueAsString(addStudentRequest);
        String response = server.getResponse("addStudent",json);
        String expectedJson = "{\"response\":{\"response\":null,\"error_validation_list\":[\"LastName is null\"],\"exception\":null},\"status\":422}";

        Assert.assertEquals(response,expectedJson);
    }

    @Test
    public void TestAddStudentEmptyName() throws Exception {
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "",
                "First",
                "Middle",
                102,
                "OK");
        String json = objectMapper.writeValueAsString(addStudentRequest);
        String response = server.getResponse("addStudent",json);
        String expectedJson = "{\"response\":{\"response\":null,\"error_validation_list\":[\"LastName is empty\"],\"exception\":null},\"status\":422}";

        Assert.assertEquals(response,expectedJson);
    }

    @Test
    public void TestDeleteNotExistStudent() throws Exception {
        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(100);
        String json = objectMapper.writeValueAsString(deleteStudentRequest);
        String response = server.getResponse("deleteStudent",json);
        String expectedJson = "{\"response\":{\"response\":null,\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(response,expectedJson);
    }
    @Test
    public void TestGetStudentById() throws Exception {
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "Last",
                "First",
                "Middle",
                102,
                "OK");
        String jsonAdd = objectMapper.writeValueAsString(addStudentRequest);
        String responseAdd = server.getResponse("addStudent",jsonAdd);
        String expectedAdd = "{\"response\":{\"response\":{\"id\":1},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(responseAdd,expectedAdd);


        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(1);
        String jsonGet = objectMapper.writeValueAsString(getStudentByIdRequest);
        String responseGet = server.getResponse("getStudentById",jsonGet);
        String expectedJson = "{\"response\":{\"response\":{\"id\":1,\"lastName\":\"Last\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":102,\"status\":\"OK\"},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(responseGet,expectedJson);
    }

    @Test
    public void TestEditStudent() throws Exception {
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "Last",
                "First",
                "Middle",
                104,
                "OK");
        String jsonAdd = objectMapper.writeValueAsString(addStudentRequest);
        String responseAdd = server.getResponse("addStudent",jsonAdd);
        String expectedAdd = "{\"response\":{\"response\":{\"id\":1},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(responseAdd,expectedAdd);

        EditStudentRequest editStudentRequest = new EditStudentRequest(
                1,
                "Edit",
                "First",
                "Middle",
                104,
                "OK"
        );
        String jsonEdit = objectMapper.writeValueAsString(editStudentRequest);
        String responseEdit = server.getResponse("editStudent",jsonEdit);
        String expectedEdit = "{\"response\":{\"response\":null,\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(responseEdit,expectedEdit);

        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(1);
        String jsonGet = objectMapper.writeValueAsString(getStudentByIdRequest);
        String responseGet = server.getResponse("getStudentById",jsonGet);
        String expectedJson = "{\"response\":{\"response\":{\"id\":1,\"lastName\":\"Edit\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(responseGet,expectedJson);
    }

    @Test
    public void TestGetStudentsByGroupAndDeleteOneOfThem() throws Exception {
        AddStudentRequest addStudentRequest1 = new AddStudentRequest(
                "Pen",
                "First",
                "Middle",
                104,
                "OK");
        AddStudentRequest addStudentRequest2 = new AddStudentRequest(
                "Banana",
                "First",
                "Middle",
                104,
                "OK");
        AddStudentRequest addStudentRequest3 = new AddStudentRequest(
                "Clown",
                "First",
                "Middle",
                104,
                "OK");
        AddStudentRequest addStudentRequest4 = new AddStudentRequest(
                "Mountain",
                "First",
                "Middle",
                101,
                "OK");

        String jsonAdd1 = objectMapper.writeValueAsString(addStudentRequest1);
        String jsonAdd2 = objectMapper.writeValueAsString(addStudentRequest2);
        String jsonAdd3 = objectMapper.writeValueAsString(addStudentRequest3);
        String jsonAdd4 = objectMapper.writeValueAsString(addStudentRequest4);
        String responseAdd1 = server.getResponse("addStudent",jsonAdd1);
        String responseAdd2 = server.getResponse("addStudent",jsonAdd2);
        String responseAdd3 = server.getResponse("addStudent",jsonAdd3);
        String responseAdd4 = server.getResponse("addStudent",jsonAdd4);

        String expectedAdd1 = "{\"response\":{\"response\":{\"id\":1},\"error_validation_list\":null,\"exception\":null},\"status\":200}";
        String expectedAdd2 = "{\"response\":{\"response\":{\"id\":2},\"error_validation_list\":null,\"exception\":null},\"status\":200}";
        String expectedAdd3 = "{\"response\":{\"response\":{\"id\":3},\"error_validation_list\":null,\"exception\":null},\"status\":200}";
        String expectedAdd4 = "{\"response\":{\"response\":{\"id\":4},\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(expectedAdd1,responseAdd1);
        Assert.assertEquals(expectedAdd2,responseAdd2);
        Assert.assertEquals(expectedAdd3,responseAdd3);
        Assert.assertEquals(expectedAdd4,responseAdd4);

        GetStudentsByGroupRequest getStudentsByGroupRequest = new GetStudentsByGroupRequest(104);
        String jsonGet = objectMapper.writeValueAsString(getStudentsByGroupRequest);
        String responseGet = server.getResponse("getStudentsByGroup",jsonGet);

        String expectedGet = "{\"response\":{\"response\":[{\"id\":1,\"lastName\":\"Pen\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"},{\"id\":2,\"lastName\":\"Banana\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"},{\"id\":3,\"lastName\":\"Clown\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"}],\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(expectedGet,responseGet);

        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(1);
        String jsonDelete = objectMapper.writeValueAsString(deleteStudentRequest);
        server.getResponse("deleteStudent",jsonDelete);


        GetStudentsByGroupRequest getStudentsByGroupRequest2 = new GetStudentsByGroupRequest(104);
        String jsonGet2 = objectMapper.writeValueAsString(getStudentsByGroupRequest2);
        String responseGet2 = server.getResponse("getStudentsByGroup",jsonGet2);

        String expectedGet2 = "{\"response\":{\"response\":[{\"id\":2,\"lastName\":\"Banana\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"},{\"id\":3,\"lastName\":\"Clown\",\"firstName\":\"First\",\"middleName\":\"Middle\",\"groupId\":104,\"status\":\"OK\"}],\"error_validation_list\":null,\"exception\":null},\"status\":200}";

        Assert.assertEquals(expectedGet2,responseGet2);
    }
}
