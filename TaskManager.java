import java.io.*;
import java.util.*;

public class TaskManager{

    List<Task> tasks = new ArrayList<>();

    File file = new File("tasks.json");
        Scanner scanner = new Scanner(System.in);

    public TaskManager(){
        loadTasks();
    }

    private void loadTasks(){

        try{

            if(!file.exists()){
                file.createNewFile();
                saveTasks();
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null){

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String descripcion = parts[1];
                String status = parts[2];

                Task task = new Task(id, descripcion);
                task.status = TaskStatus.valueOf(status);

                tasks.add(task);

            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void saveTasks(){

        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for(Task task : tasks){

                writer.write(task.id + "|" + task.descripcion + "|" + task.status + "|" + task.fechaCreacion + "|" + task.fechaUpdate);
                writer.newLine();

            }

            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void addTask(String descripcion){

        int id = tasks.size() + 1;

        Task newTask = new Task(id, descripcion);

        tasks.add(newTask);

        saveTasks();

        System.out.println("Tarea agregada con ID: " + id);

    }

    public void listTasks(){

        if(tasks.isEmpty()){
            System.out.println("No hay tareas");
            return;
        }

        for(Task task : tasks){
            System.out.println(task.id + " - " + task.descripcion + " - " + task.status);
        }

    }

    public void deleteTask ( int id){
        Task taskRemove = null;

        for (Task task: tasks){
            if(task.id == id){
                taskRemove = task;
                break;
            }

        }
        if (taskRemove != null){
            tasks.remove(taskRemove);
            saveTasks();
            System.out.println("Tarea eliminada");
        }else{
            System.out.println("No se encontro la tarea");
        }
    }

    public void markDone (int id){

        for(Task task : tasks){
            if(task.id == id){
                task.status = TaskStatus.DONE;
                saveTasks();
                System.out.println("Tarea marcada como DONE");
                return;
            }
        }
        System.out.println("No se encontro la tares");


    }
    public void markInProgress(int id){

        for(Task task : tasks){

            if(task.id == id){
                task.status = TaskStatus.IN_PROGRESS;
                saveTasks();
                System.out.println("Tarea marcada como en progreso");
                return;
            }

        }
        System.out.println("Tarea no encontrada");


    }
   public void updateTask(int id){

    Scanner scanner = new Scanner(System.in);

    for(Task task : tasks){

        if(task.id == id){

            System.out.println("Ingrese nueva descripcion");

            task.descripcion = scanner.nextLine();
            task.fechaUpdate = java.time.LocalDateTime.now().toString();

            saveTasks();

            System.out.println("Tarea Actualizada");

            return;
        }
    }

    System.out.println("Tarea no encontrada");

}

    public void listaStatus (TaskStatus status){

        for(Task task : tasks){
            if(task.status == status){
                System.out.println(task.id + " - " + task.descripcion + " - " + task.status);

            }
        }



    }

   

}