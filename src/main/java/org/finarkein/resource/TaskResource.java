package org.finarkein.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.*;

@Path("/api/v1/tasks")
public class TaskResource {


    List<Task> taskList = new ArrayList<>(
        Arrays.asList(
            new Task(false, "6412120dbb51e7002dd90266", "wash dishes"),
            new Task(false, "6412120dbb51e7002dd90267", "solve problems"),
            new Task(false, "6412120dbb51e7002dd90268", "do coding")
        )
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMobileList() {
        return Response.ok(taskList).build();
    }


    @DELETE
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTask(@PathParam("taskId") String taskId) {
        boolean isRemoved = taskList.removeIf(task -> task.getId().equals(taskId));
        if (isRemoved) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}



    // import java.util.stream.Collectors;

    // List<String> taskList = new ArrayList<>(
    //         Arrays.asList(
    //                 "Wash Dishes",
    //                 "Solve Problems",
    //                 "Do Coding"
    //         ));

    // @POST
    // @Consumes(MediaType.TEXT_PLAIN)
    // @Produces(MediaType.TEXT_PLAIN)
    // public Response addNewMobile(String taskName){
    //     taskList.add(taskName);
    //     return Response.ok(taskList).build();
    // }

    // @PUT
    // @Path("/{oldtaskname}")
    // @Consumes(MediaType.TEXT_PLAIN)
    // @Produces(MediaType.TEXT_PLAIN)
    // public Response updateMobile(@PathParam("oldtaskname") String oldMobileName,
    //                              @QueryParam("newtaskname") String newMobileName) {
    //     System.out.println(oldMobileName);
    //     System.out.println(newMobileName);

    //     taskList = taskList.stream().map(task -> {
    //         if(task.equals(oldMobileName)){
    //             return newMobileName;
    //         }
    //         else {
    //             return task;
    //         }
    //     }).collect(Collectors.toList());
    //     System.out.println(taskList);
    //     return Response.ok(taskList).build();
    // }


    // @DELETE
    // @Produces(MediaType.TEXT_PLAIN)
    // @Consumes(MediaType.TEXT_PLAIN)
    // @Path("{taskToDelete}")
    // public Response taskToDelete(@PathParam("taskToDelete") String taskName)
    // {
    //     boolean isRemoved = taskList.remove(taskName);
    //     if(isRemoved){
    //         return Response.ok(taskList).build();
    //     }
    //     return Response.status(Response.Status.BAD_REQUEST).build();
    // }