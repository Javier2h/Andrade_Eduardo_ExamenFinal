package com.portfolio.service;

import com.portfolio.model.OptimizarRequest;
import com.portfolio.model.OptimizarResponse;
import com.portfolio.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OptimizarServiceTest {
    @Autowired
    private OptimizarService service;

    @Test
    void testCasoNormal() {
        OptimizarRequest req = new OptimizarRequest();
        req.setCapacidad(10000);
        req.setObjetos(List.of(
            new Proyecto(null, "A", 2000, 1500),
            new Proyecto(null, "B", 4000, 3500),
            new Proyecto(null, "C", 5000, 4000),
            new Proyecto(null, "D", 3000, 2500)
        ));
        OptimizarResponse resp = service.optimizar(req);
    assertEquals(8000, resp.getGanancia_total());
    assertEquals(10000, resp.getPeso_total());
    assertTrue(resp.getSeleccionados().size() >= 2); // Puede haber más de una combinación válida
    }

    @Test
    void testCapacidadCero() {
        OptimizarRequest req = new OptimizarRequest();
        req.setCapacidad(0);
        req.setObjetos(List.of(
            new Proyecto(null, "A", 2000, 1500)
        ));
        OptimizarResponse resp = service.optimizar(req);
        assertTrue(resp.getSeleccionados().isEmpty());
        assertEquals(0, resp.getGanancia_total());
        assertEquals(0, resp.getPeso_total());
    }

    @Test
    void testSinProyectos() {
        OptimizarRequest req = new OptimizarRequest();
        req.setCapacidad(1000);
        req.setObjetos(List.of());
        OptimizarResponse resp = service.optimizar(req);
        assertTrue(resp.getSeleccionados().isEmpty());
    }

    @Test
    void testProyectoMayorQueCapacidad() {
        OptimizarRequest req = new OptimizarRequest();
        req.setCapacidad(1000);
        req.setObjetos(List.of(
            new Proyecto(null, "A", 2000, 1500)
        ));
        OptimizarResponse resp = service.optimizar(req);
        assertTrue(resp.getSeleccionados().isEmpty());
    }

    @Test
    void testTodosProyectosCabida() {
        OptimizarRequest req = new OptimizarRequest();
        req.setCapacidad(10000);
        req.setObjetos(List.of(
            new Proyecto(null, "A", 2000, 1500),
            new Proyecto(null, "B", 4000, 3500)
        ));
        OptimizarResponse resp = service.optimizar(req);
        assertEquals(List.of("A", "B"), resp.getSeleccionados());
    }
}
