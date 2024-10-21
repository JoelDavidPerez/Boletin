public class Candidato {
    private int votosObtenidos;
    private String nombre;
    private String partidoPolitico;

    public Candidato(String nombre, String partidoPolitico) {
        this.nombre = nombre;
        this.votosObtenidos = 0;
        this.partidoPolitico = partidoPolitico;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartidoPolitico() {
        return this.partidoPolitico;
    }

    public int getVotosObtenidos() {
        return this.votosObtenidos;
    }

    public void setVotosObtenidos(int votosObtenidos) {
        this.votosObtenidos = votosObtenidos;
    }

    public String mostrarInfo() {
        return "Nombre del candidato: " + this.nombre + ", puntos obtenidos: " + this.votosObtenidos;
    }
}
