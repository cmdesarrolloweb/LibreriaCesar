package libreria.entidades;

import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Prestamo {
    
    @Id
    private String id;
    
    @ManyToOne
    @Column(nullable = false)
    private Libro libro;
    
    @ManyToOne
    @Column(nullable = false)
    private Cliente cliente;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_prestamo", nullable = false)
    private Date fecha;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_devolucion", nullable = false)
    private Date devolucion;

    public Prestamo() {
    }

    public Prestamo(String id, Libro libros, Cliente cliente, Date fecha, Date devolucion) {
        this.id = id;
        this.libro = libros;
        this.cliente = cliente;
        this.fecha = fecha;
        this.devolucion = devolucion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libros) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }
    
    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", libro=" + libro + ", cliente=" + cliente + ", fecha=" + fecha + ", devolucion=" + devolucion + '}';
    }
    
}
