import org.example.EvaluacionFinal;

import static org.junit.jupiter.api.Assertions.*;




class EvaluacionFinalTest {

    @org.junit.jupiter.api.Test
    void testcalcularNotaFinal() {

        EvaluacionFinal eva = new EvaluacionFinal();
       double valoresperado=6.699999999999999;
       double valorfinal=eva.calcularNotaFinal(6,7,8);
       assertEquals(valoresperado,valorfinal);



    }

    @org.junit.jupiter.api.Test
    void testobtenerResultadoSuspenso() {
        EvaluacionFinal ev = new EvaluacionFinal();
        //voy a porbar suspenso
        String valoresperado = "Suspenso";
        String valorfinal = ev.obtenerResultado(4.9);
        assertEquals(valoresperado,valorfinal);


    }
    @org.junit.jupiter.api.Test
    void testobtenerResultadoAprobado() {
        EvaluacionFinal ev = new EvaluacionFinal();
        //voy a porbar suspenso
        String valoresperado = "Aprobado";
        String valorfinal = ev.obtenerResultado(5.0 );
        assertEquals(valoresperado,valorfinal);


    }

    @org.junit.jupiter.api.Test
    void testobtenerResultadoNotable() {
        EvaluacionFinal ev = new EvaluacionFinal();
        //voy a porbar suspenso
        String valoresperado = "Notable";
        String valorfinal = ev.obtenerResultado(8.9);
        assertEquals(valoresperado,valorfinal);


    }

    @org.junit.jupiter.api.Test
    void testobtenerResultadoSobresaliente() {
        EvaluacionFinal ev = new EvaluacionFinal();
        //voy a porbar suspenso
        String valoresperado = "Sobresaliente";
        String valorfinal = ev.obtenerResultado(10);
        assertEquals(valoresperado,valorfinal);


    }

    @org.junit.jupiter.api.Test
    void estaAprobadotrue() {
        EvaluacionFinal ev = new EvaluacionFinal();

        assertTrue(ev.estaAprobado(6));

    }
    @org.junit.jupiter.api.Test
    void estaAprobadofalse() {
        EvaluacionFinal ev = new EvaluacionFinal();

        assertTrue(ev.estaAprobado(2));

    }


    @org.junit.jupiter.api.Test
    void calcularMedia() {

          EvaluacionFinal ev = new EvaluacionFinal();

          double valoresperado=6.9;
          double notas [] ={6,7,8};
          double valorfinal=ev.calcularMedia(notas);
          assertEquals(valoresperado,valorfinal);
    }

    @org.junit.jupiter.api.Test
    void validarNotatest() {

        EvaluacionFinal eva = new EvaluacionFinal();
        double valoresperado=4.9;
        double valorfinal=eva.validarNota(0);
        assertEquals(valoresperado,valorfinal);



    }

    @org.junit.jupiter.api.Test
    void validarNotatestNegativa() {

        EvaluacionFinal eva = new EvaluacionFinal();
        double valoresperado=1;
        double valorfinal=eva.validarNota(-1);
        assertEquals(valoresperado,valorfinal);



    }
    @org.junit.jupiter.api.Test
    void calcularMediaVacio() {

        EvaluacionFinal ev = new EvaluacionFinal();

        double valoresperado=3;
        double[] notas = new double[5];
        double valorfinal=ev.calcularMedia(notas);
        assertEquals(valoresperado,valorfinal);
    }

    @org.junit.jupiter.api.Test
    void validarNotatestAlta() {

        EvaluacionFinal eva = new EvaluacionFinal();
        double valoresperado=10;
        double valorfinal=eva.validarNota(12);
        assertEquals(valoresperado,valorfinal);



    }
}
