
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Eleccion {
    private String nombreEleccion;
    private int dia;
    private int mes;
    private int ano;
    private String fecha;
    private ArrayList<Candidato> candidatos;
    private Candidato candidato;

    public Eleccion(String nombreEleccion) {
        this.nombreEleccion = nombreEleccion;
        this.fecha = this.fecha;
        this.candidatos = new ArrayList();
    }

    public void agregarCandidato(Candidato candidato) {
        this.candidatos.add(candidato);
    }

    public void mostrarEleccion() {
        StringBuilder infoEleccion = new StringBuilder();
        infoEleccion.append("-".repeat(30) + "\n");
        infoEleccion.append("Nombre elección: ").append(this.nombreEleccion).append("\n");
        infoEleccion.append("-".repeat(30) + "\n");
        infoEleccion.append("Fecha: ").append(this.fecha).append("\n");
        String var10001 = "-".repeat(15);
        infoEleccion.append(var10001 + "|" + "-".repeat(15) + "\n");
        infoEleccion.append(String.format("%-15s | %-15s | %-15s%n", "Nombre", "Partido político", "Resultados"));
        var10001 = "-".repeat(15);
        infoEleccion.append(var10001 + "|" + "-".repeat(15) + "\n");
        Iterator var2 = this.candidatos.iterator();

        while(var2.hasNext()) {
            Candidato candidato = (Candidato)var2.next();
            infoEleccion.append(String.format("%-15s | %-15s | %-15s%n", candidato.getNombre(), candidato.getPartidoPolitico(), candidato.getVotosObtenidos()));
        }

        JOptionPane.showMessageDialog((Component)null, infoEleccion.toString(), "Información electoral", 1);
    }

    public void agregarFecha() {
        this.fecha = JOptionPane.showInputDialog((Component)null, "Ingrese la fecha de la elección: " + this.nombreEleccion + " en formato (DD/MM/AAAA):");
        if (this.fecha != null && !this.fecha.trim().isEmpty()) {
            String[] partesFecha = this.fecha.split("/");
            if (partesFecha.length == 3) {
                try {
                    int dia = Integer.parseInt(partesFecha[0]);
                    int mes = Integer.parseInt(partesFecha[1]);
                    int ano = Integer.parseInt(partesFecha[2]);
                    if (dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && ano > 0) {
                        this.dia = dia;
                        this.mes = mes;
                        this.ano = ano;
                        this.fecha = String.format("%02d/%02d/%04d", dia, mes, ano);
                        JOptionPane.showMessageDialog((Component)null, "Fecha agregada satisfactoriamente: " + this.fecha);
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Fecha inválida. Asegúrate de que el día, mes y año sean correctos.");
                    }
                } catch (NumberFormatException var5) {
                    JOptionPane.showMessageDialog((Component)null, "Formato de fecha inválido. Intenta nuevamente.");
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "Formato de fecha incorrecto. Usa el formato DD/MM/AAAA.");
            }
        } else {
            JOptionPane.showMessageDialog((Component)null, "No se ingresó ninguna fecha.");
        }

    }

    public boolean setVotosObtenidos(String nombreCandidato, int votos) {
        Iterator var3 = this.candidatos.iterator();

        Candidato candidato;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            candidato = (Candidato)var3.next();
        } while(!candidato.getNombre().equalsIgnoreCase(nombreCandidato));

        candidato.setVotosObtenidos(votos);
        return true;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getNombreEleccion() {
        return this.nombreEleccion;
    }

    public void setNombreEleccion(String nombreEleccion) {
        this.nombreEleccion = nombreEleccion;
    }

    public ArrayList<Candidato> getCandidatos() {
        return this.candidatos;
    }
}

