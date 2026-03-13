import java.time.LocalDateTime;

public class Task{
    public int id;
    public String descripcion;
    public TaskStatus status;
    public String fechaCreacion;
    public String fechaUpdate;
    public Task ( int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        this.status = TaskStatus.TODO;
        this.fechaCreacion = LocalDateTime.now().toString();
        this.fechaUpdate = LocalDateTime.now().toString();

    }


}