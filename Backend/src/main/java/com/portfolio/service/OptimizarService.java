package com.portfolio.service;

import com.portfolio.model.OptimizarRequest;
import com.portfolio.model.OptimizarResponse;
import com.portfolio.model.Proyecto;
import com.portfolio.model.ResultadosHistoricos;
import com.portfolio.repository.ResultadosHistoricosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OptimizarService {
    @Autowired
    private ResultadosHistoricosRepository resultadosHistoricosRepository;

    public OptimizarResponse optimizar(OptimizarRequest request) {
        int n = request.getObjetos().size();
        int capacidad = request.getCapacidad();
        List<Proyecto> objetos = request.getObjetos();
        int[][] dp = new int[n + 1][capacidad + 1];
        boolean[][] keep = new boolean[n][capacidad + 1];
        for (int i = 0; i < n; i++) {
            int peso = objetos.get(i).getPeso();
            int ganancia = objetos.get(i).getGanancia();
            for (int w = 0; w <= capacidad; w++) {
                if (peso <= w) {
                    if (dp[i][w - peso] + ganancia > dp[i][w]) {
                        dp[i + 1][w] = dp[i][w - peso] + ganancia;
                        keep[i][w] = true;
                    } else {
                        dp[i + 1][w] = dp[i][w];
                    }
                } else {
                    dp[i + 1][w] = dp[i][w];
                }
            }
        }
        List<String> seleccionados = new ArrayList<>();
        int w = capacidad, peso_total = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (keep[i][w]) {
                seleccionados.add(objetos.get(i).getNombre());
                peso_total += objetos.get(i).getPeso();
                w -= objetos.get(i).getPeso();
            }
        }
        Collections.reverse(seleccionados);
        OptimizarResponse response = new OptimizarResponse(seleccionados, dp[n][capacidad], peso_total);
        // Guardar resultado histórico
        ResultadosHistoricos historico = new ResultadosHistoricos(
            String.join(",", seleccionados),
            response.getGanancia_total(),
            response.getPeso_total(),
            java.time.LocalDateTime.now()
        );
        resultadosHistoricosRepository.save(historico);
        return response;
    }
}
