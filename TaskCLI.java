import java.util.Scanner;

public class TaskCLI{

    public static void main(String[] args){

        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0){
            System.out.println("Usar comando: add, list");
            return;

        }
        String command = args[0];
        switch (command){
            case "add":
                System.out.println("Escribe la tarea que desea agregar");
                String descripcion = scanner.nextLine();
                manager.addTask(descripcion);
                break;
            case "list":
                System.out.println("lista de tareas");
                manager.listTasks();
                break;
            case "delete":
                System.out.println("Id de la tarea a eliminar: ");
                int id = scanner.nextInt();
                manager.deleteTask(id);
                break;  
            case "done":
                System.out.println("Ingrese ID de la tarea quiere marcar como DONE: ");
                int id1 = scanner.nextInt();
                manager.markDone(id1);
                break;
            case "progress":
                System.out.println("Ingrese ID de la tarea que quiere marcar como EN PROGRESO: ");
                int id2 = scanner.nextInt();
                manager.markInProgress(id2);
                break;

            case "update":
                System.out.println("ingrese id de la tarea a modificar");
                int id3 = scanner.nextInt();
                manager.updateTask(id3);
                break;

            default:
                System.out.println("no reconoce comando");
        }


    }



}