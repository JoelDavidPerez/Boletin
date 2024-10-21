//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Controlador {
    private ArrayList<Eleccion> elecciones = new ArrayList();
    private Eleccion eleccion;

    public Controlador() {
    }

    public void run() {
        String[] opciones = new String[]{"Crear elección", "Seleccionar Eleccion", "Agregar fecha", "Agregar elecciones predeterminadas", "Agregar candidato", "Ingresar resultados", "Modificar resultados", "Mostrar resultados", "Salir"};

        while(true) {
            String opcion = (String)JOptionPane.showInputDialog((Component)null, "Seleccione una opción", "Menú de gestión del curso", 3, (Icon)null, opciones, opciones[0]);
            if (opcion == null) {
                JOptionPane.showMessageDialog((Component)null, "Menu cerrado");
                return;
            }

            switch (opcion) {
                case "Crear elección":
                    this.crearEleccion();
                    break;
                case "Seleccionar Eleccion":
                    this.seleccionarEleccion();
                    break;
                case "Agregar fecha":
                    this.agregarFecha();
                    break;
                case "Agregar elecciones predeterminadas":
                    this.agregarEleccionesPredeterminadas();
                    break;
                case "Agregar candidato":
                    this.agregarCandidato();
                    break;
                case "Ingresar resultados":
                    this.ingresarResultados();
                    break;
                case "Modificar resultados":
                    this.modificarVotos();
                    break;
                case "Mostrar resultados":
                    this.mostrarResultados();
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog((Component)null, "Menu cerrado");
            }
        }
    }

    private void agregarCandidatosPredeterminados() {
        String[][] candidatosPredeterminados = new String[][]{{"Andrés Manuel López Obrador", "MORENA", "200"}, {"Ivan Duque", "Centro democrático", "210"}, {"Vladimir Putin", "Union soviética", "360"}, {"Gustavo Petro", "Colombia Humana", "360"}, {"Lula da Silva", "Partido de los Trabajadores", "350"}};
        if (this.eleccion != null) {
            String[][] var2 = candidatosPredeterminados;
            int var3 = candidatosPredeterminados.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String[] candidatoData = var2[var4];
                Candidato candidato = new Candidato(candidatoData[0], candidatoData[1]);
                int votos = Integer.parseInt(candidatoData[2]);
                candidato.setVotosObtenidos(votos);
                this.eleccion.agregarCandidato(candidato);
            }

            JOptionPane.showMessageDialog((Component)null, "Candidatos predeterminados agregados exitosamente.");
        } else {
            JOptionPane.showMessageDialog((Component)null, "Crea primero la elección.");
        }

    }

    private void agregarEleccionesPredeterminadas() {
        String[][][] eleccionesPredeterminadas = new String[][][]{{{"Elección Presidencial 2020"}, {"Bernie Sanders", "Izquierda", "350"}, {"Alexandria Ocasio-Cortez", "Izquierda", "300"}, {"Jeremy Corbyn", "Izquierda", "280"}, {"Donald Trump", "Derecha", "400"}, {"Jair Bolsonaro", "Derecha", "370"}}, {{"Elección Presidencial 2018"}, {"Gustavo Petro", "Izquierda", "320"}, {"Jean-Luc Mélenchon", "Izquierda", "310"}, {"Lula da Silva", "Izquierda", "340"}, {"Iván Duque", "Derecha", "380"}, {"Sebastián Piñera", "Derecha", "360"}}, {{"Elección Presidencial 2016"}, {"Pablo Iglesias", "Izquierda", "290"}, {"Evo Morales", "Izquierda", "310"}, {"Nicolás Maduro", "Izquierda", "300"}, {"Mauricio Macri", "Derecha", "350"}, {"Marine Le Pen", "Derecha", "330"}}};
        String[][][] var2 = eleccionesPredeterminadas;
        int var3 = eleccionesPredeterminadas.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String[][] eleccionData = var2[var4];
            Eleccion nuevaEleccion = new Eleccion(eleccionData[0][0]);
            this.elecciones.add(nuevaEleccion);

            for(int i = 1; i < eleccionData.length; ++i) {
                String[] candidatoData = eleccionData[i];
                Candidato candidato = new Candidato(candidatoData[0], candidatoData[1]);
                int votos = Integer.parseInt(candidatoData[2]);
                candidato.setVotosObtenidos(votos);
                nuevaEleccion.agregarCandidato(candidato);
            }
        }

        JOptionPane.showMessageDialog((Component)null, "Tres elecciones predeterminadas con candidatos han sido agregadas exitosamente.");
    }

    private void crearEleccion() {
        String nombreEleccion = JOptionPane.showInputDialog((Component)null, "Ingrese el nombre del eleccion");
        if (nombreEleccion == null) {
            JOptionPane.showMessageDialog((Component)null, "Dato erróneo. Ingrese el nombre del eleccion");
        } else {
            JOptionPane.showMessageDialog((Component)null, nombreEleccion + " Agregado exitosamente");
            this.eleccion = new Eleccion(nombreEleccion);
            this.elecciones.add(this.eleccion);
        }

    }

    private void seleccionarEleccion() {
        if (this.elecciones != null && this.elecciones.size() != 0) {
            String[] nombreElecciones = new String[this.elecciones.size()];

            for(int i = 0; i < this.elecciones.size(); ++i) {
                nombreElecciones[i] = ((Eleccion)this.elecciones.get(i)).getNombreEleccion();
            }

            String eleccionEscogida = (String)JOptionPane.showInputDialog((Component)null, "Seleccione Elección", "Selección de elección", 3, (Icon)null, nombreElecciones, nombreElecciones[0]);
            if (eleccionEscogida != null) {
                Iterator var3 = this.elecciones.iterator();

                while(var3.hasNext()) {
                    Eleccion auxEleccion = (Eleccion)var3.next();
                    if (auxEleccion.getNombreEleccion().equals(eleccionEscogida)) {
                        this.eleccion = auxEleccion;
                        break;
                    }
                }

                JOptionPane.showMessageDialog((Component)null, "Eleccion" + eleccionEscogida + "seleccionado correctamente");
            } else {
                JOptionPane.showMessageDialog((Component)null, "No hubo selección escogida", "Error", 0);
            }

        } else {
            JOptionPane.showMessageDialog((Component)null, "No hay elecciones disponibles", "Error", 0);
        }
    }

    public void agregarFecha() {
        if (this.eleccion != null) {
            this.eleccion.agregarFecha();
        } else {
            JOptionPane.showMessageDialog((Component)null, "Crea primero la elección");
        }

    }

    private void modificarVotos() {
        if (this.eleccion == null) {
            JOptionPane.showMessageDialog((Component)null, "Crea primero la elección.", "ERROR", 0);
        } else {
            String nombreCandidato = JOptionPane.showInputDialog((Component)null, "Ingrese el nombre del candidato para modificar los votos:");
            if (nombreCandidato != null && !nombreCandidato.trim().isEmpty()) {
                String votosStr = JOptionPane.showInputDialog((Component)null, "Ingrese la nueva cantidad de votos:");
                if (votosStr != null && !votosStr.trim().isEmpty()) {
                    try {
                        int nuevosVotos = Integer.parseInt(votosStr);
                        boolean actualizado = this.eleccion.setVotosObtenidos(nombreCandidato, nuevosVotos);
                        if (actualizado) {
                            JOptionPane.showMessageDialog((Component)null, "Votos actualizados exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se encontró al candidato: " + nombreCandidato, "Error", 0);
                        }
                    } catch (NumberFormatException var5) {
                        JOptionPane.showMessageDialog((Component)null, "Cantidad de votos inválida.", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "No se ingresó una cantidad válida de votos.");
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "No se ingresó el nombre del candidato.");
            }

        }
    }

    private void mostrarResultados() {
        if (this.eleccion != null) {
            this.eleccion.mostrarEleccion();
        } else {
            JOptionPane.showMessageDialog((Component)null, "Crea primero la elección");
        }

    }

    private void agregarCandidato() {
        if (this.eleccion == null) {
            JOptionPane.showMessageDialog((Component)null, "Crea una elección primero", "ERROR", 0);
        }

        String nombre = JOptionPane.showInputDialog((Component)null, "Ingrese el nombre del candidato");
        String partidoPolitico = JOptionPane.showInputDialog((Component)null, "Ingrese el partido del candidato");
        if (nombre != null && !nombre.trim().isEmpty()) {
            Candidato candidato = new Candidato(nombre, partidoPolitico);
            this.eleccion.agregarCandidato(candidato);
            JOptionPane.showMessageDialog((Component)null, "Candidato agregado exitosamente");
        } else {
            JOptionPane.showMessageDialog((Component)null, nombre + "No se puede agregar el candidato");
        }

    }

    public void ingresarResultados() {
        if (this.eleccion == null) {
            JOptionPane.showMessageDialog((Component)null, "Crea una elección primero", "ERROR", 0);
        }

        String nombreCandidato = JOptionPane.showInputDialog((Component)null, "Ingrese el nombre del candidato");
        if (nombreCandidato != null && !nombreCandidato.trim().isEmpty()) {
            String voto = JOptionPane.showInputDialog((Component)null, "Ingrese la cantidad de votos del candidato");
            if (voto != null && !voto.trim().isEmpty()) {
                try {
                    int votos = Integer.parseInt(voto);
                    boolean logrado = this.eleccion.setVotosObtenidos(nombreCandidato, votos);
                    if (logrado) {
                        JOptionPane.showMessageDialog((Component)null, "Votos agregados exitosamente");
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Error en el proceso de: " + nombreCandidato + ". Revisa el nombre", "ERROR", 0);
                    }
                } catch (NumberFormatException var5) {
                    JOptionPane.showMessageDialog((Component)null, "votos inválidos", "ERROR", 0);
                }
            }
        }

    }

    public static void main(String[] args) {
        Controlador controller = new Controlador();
        controller.run();
    }
}