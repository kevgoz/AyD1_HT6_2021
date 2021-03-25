/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proceso;
import Objetos.Carrera;
import Objetos.Horario;
import Objetos.RegistroAcademico;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

//https://oak.dev/2020/03/03/maven-error-return-code-is-501-reasonphrase-https-required/
/**
 *
 * @author GAMUSA
 */
public class KelvinManfredyVasquezGomezTEST 
{
    
    @InjectMocks
    AsignarHorario asig_horario;
    
    @Mock
    Carrera carrera;
    
    @Mock
    RegistroAcademico reg_academico;
    
    @BeforeEach
    public void setUp() 
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    @Test
    public void ObtenerCodigoHorarioTest() 
    {
        when(reg_academico.cheequearCarnet()).thenReturn(true);
        when(reg_academico.getAnio()).thenReturn(2012);
        try {
            when(carrera.procesarCarrera()).thenReturn(3);
            Horario horario = asig_horario.generarHorario(carrera, reg_academico);
            assertEquals(265, horario.getCodigoHorario());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void ObtenerDescripcionTest() {
        when(reg_academico.cheequearCarnet()).thenReturn(true);
        when(reg_academico.getAnio()).thenReturn(2012);
        try {
            when(carrera.procesarCarrera()).thenReturn(3);
            Horario horario = asig_horario.generarHorario(carrera, reg_academico);
            assertEquals("Matutino", horario.getDescripcion());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
