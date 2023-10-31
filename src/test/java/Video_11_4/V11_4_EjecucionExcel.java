package Video_11_4;

import Entidades.Facebook.Video_7.V7_Ent_RegistroFacebook;
import Escenarios.Facebook.Video_9.V9_Esc_PaginaInicioFacebook;
import Recursos.Data.Excel.Dat_Excel;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.swing.table.DefaultTableModel;

public class V11_4_EjecucionExcel {
    public static WebDriver driver;
    V9_Esc_PaginaInicioFacebook V9_esc_paginaInicioFacebook;
    V7_Ent_RegistroFacebook v7_ent_registroFacebook;
    Dat_Excel dat_excel;

    int numerofilas = 0; // Número de fila a actualizar (índice 0)


    @Before
    public void PreEjecucion() {
        dat_excel = new Dat_Excel();
        numerofilas = dat_excel.obtenerFilas();

    }
    public void AbrirNavegador(){
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador("https://es-la.facebook.com/");
    }

    public void CerrarNavegador() {
        driver.close();
        driver.quit();
    }

    public void InstanciasBasicas(){

        v7_ent_registroFacebook = new V7_Ent_RegistroFacebook();
         V9_esc_paginaInicioFacebook = new V9_Esc_PaginaInicioFacebook(driver);


    }

    public void LecturaDatos(int numerofila) {

        dat_excel.excelAbrirConexion(false);
        dataTable = dat_excel.excelTabla();


        v7_ent_registroFacebook.nombre = dat_excel.obtenerValorColumna(numerofila,"nombre").toString();
        v7_ent_registroFacebook.apellido =dat_excel.obtenerValorColumna(numerofila,"apellido").toString();
        v7_ent_registroFacebook.correo =dat_excel.obtenerValorColumna(numerofila,"correo").toString();
        v7_ent_registroFacebook.clave =dat_excel.obtenerValorColumna(numerofila,"clave").toString();
        v7_ent_registroFacebook.dia = dat_excel.obtenerValorColumna(numerofila,"dia").toString();
        v7_ent_registroFacebook.ano =dat_excel.obtenerValorColumna(numerofila,"ano").toString();
        v7_ent_registroFacebook.mes =dat_excel.obtenerValorColumna(numerofila,"mes").toString();
        v7_ent_registroFacebook.sexo =dat_excel.obtenerValorColumna(numerofila,"sexo").toString();


        dat_excel.excelCerrarConexion();
    }
    private DefaultTableModel dataTable;

    @Test
    public void ModificarElementos() {

        for (int numerofila = 0; numerofila < numerofilas; numerofila++) {

            AbrirNavegador();
            InstanciasBasicas();
            LecturaDatos(numerofila);
            V9_esc_paginaInicioFacebook.RegistroFacebook(v7_ent_registroFacebook);

            CerrarNavegador();
        }
    }
}
