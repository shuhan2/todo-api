//package com.thoughtworks.restfulapi.restfulapi;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.thoughtworks.restfulapi.restfulapi.model.Todo;
//import com.thoughtworks.restfulapi.restfulapi.service.TodoService;
//import org.apache.catalina.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.*;
//
//import static javafx.beans.binding.Bindings.when;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static sun.nio.cs.Surrogate.is;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class RestfulapiApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//    private TodoService todoService;
//
//    @Test
//    public void getTodoList() throws Exception {
//        Todo todo = new Todo(9, "wzzheng", "finished", new Date(),"1");
//        Todo todoNew = new Todo(10, "todoNew", "to do", new Date(),"2");
//
//        List<Todo> todoList = Arrays.asList(todo, todoNew);
//
//        given(todoService.getTodoList()).willReturn(todoList);
//
//        mockMvc.perform(
//                get("/todo"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].name").value("wzzheng"))
//                .andExpect(jsonPath("$[1].name").value("todoNew"));
//    }
//
//
//    @Test
//    public void getTodoById() throws Exception {
//        Todo todoNew = new Todo(9, "wzzheng", "finished", new Date(),"1");
//
//        given(todoService.getTodoById(todoNew.getId())).willReturn(todoNew);
//
//        mockMvc.perform(
//                get("/todo/{id}", todoNew.getId()))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.name").value("wzzheng"))
//                .andExpect(jsonPath("$.status").value("finished"));
//    }
//
//    @Test
//    public void addTodo() throws Exception {
//        Todo todoNew = new Todo(9, "todoNew", "to do", new Date(),"1");
//
//        given(todoService.updateTodoById(todoNew.getId(),todoNew)).willReturn(todoNew);
//
//        mockMvc.perform(
//                post("/todo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(todoNew)))
//                .andExpect(status().isOk());
//        verify(todoService, times(1)).updateTodoById(todoNew.getId(),todoNew);
//        verifyNoMoreInteractions(todoService);
//    }
//
//    @Test
//    public void deleteTodoById() throws Exception {
//        Todo todoNew = new Todo(1, "todoNew", "to do", new Date(),"1");
//
//        doNothing().when(todoService).deleteById(todoNew.getId());
//
//        mockMvc.perform(
//                delete("/todo/{id}", todoNew.getId()))
//                .andExpect(status().isOk());
//
//        verify(todoService, times(1)).getTodoById(todoNew.getId());
//        verify(todoService, times(1)).deleteById(todoNew.getId());
//        verifyNoMoreInteractions(todoService);
//    }
//
//    @Test
//    public void updateTodo() throws Exception {
//        Todo todoNew = new Todo(1, "todoNew", "to do", new Date(),"1");
//
//        given(todoService.getTodoById(todoNew.getId())).willReturn(todoNew);
//        given(todoService.updateTodoById(todoNew.getId(),todoNew)).willReturn(todoNew);
//
//        mockMvc.perform(
//                put("/todo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(todoNew)))
//                .andExpect(status().isOk());
//
//        verify(todoService, times(1)).getTodoById(todoNew.getId());
//        verify(todoService, times(1)).updateTodoById(todoNew.getId(),todoNew);
//        verifyNoMoreInteractions(todoService);
//    }
//
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
////	@Test
////	public void should() throws Exception {
////		String content =  mockMvc.perform(get("/todo/{id}",1))
////				.andReturn()
////				.getResponse()
////				.getContentAsString();
////	}
////
////    @Test
////    public void shouldReturnItemList() throws Exception {
////        mockMvc.perform(get("/todo"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.length()").value(4))
////                .andExpect(jsonPath("$[0].id").value(1))
////                .andExpect(jsonPath("$[0].name").value("meeting"))
////                .andExpect(jsonPath("$[0].status").value("To Do"))
////                .andExpect(jsonPath("$[0].tags").value("1"));
////    }
//
////    @Test
////    public void getTodoById() throws Exception {
////
////        mockMvc.perform(get("/todo/${id}", 1L))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.name").value("meeting"))
////                .andExpect(jsonPath("$.status").value("to do"));
////    }
////
////
////    @Test
////    public void addTodo() throws Exception {
////        Todo todoNew = new Todo(10, "todoNew", "to do", new Date(),"tag");
////
////        given(todoService.addTodo(todoNew)).willReturn(todoNew);
////
////        mockMvc.perform(
////                post("/todo")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content((todoNew)))
////                .andExpect(status().isOk());
////        verify(todoService, times(1)).addTodo(todoNew);
////        verifyNoMoreInteractions(todoService);
////    }
////
//
////    @Test
////    public void deleteTodoById() throws Exception {
////
////        Todo todoNew = new Todo(9, "todoNew", "to do", new Date(),"tag1");
////
////        when(toDoService.getTodoById(todoNew.getId())).thenReturn(todoNew);
////        doNothing().when(toDoService).delete(todoNew.getId());
////
////        mvc.perform(
////                delete("/todos/{id}", todoNew.getId()))
////                .andExpect(status().isOk());
////
////        verify(toDoService, times(1)).getTodoById(todoNew.getId());
////        verify(toDoService, times(1)).delete(todoNew.getId());
////        verifyNoMoreInteractions(toDoService);
////    }
//
//
//
//
//
//}
//
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//@RunWith()
