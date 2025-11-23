package iscae.mpiag.tp1.config.actuator.controller;

import iscae.mpiag.tp1.config.actuator.service.ActuatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MonitoringController {

    private final ActuatorService service;

    @GetMapping("/monitoring")
    public String monitoring(Model model) {
        // Thymeleaf will load template; JS will fetch metrics dynamically
        return "monitoring";
    }

    // REST endpoint for live metrics
    @GetMapping("/monitoring/data")
    @ResponseBody
    public Map<String, Object> getMonitoringData() {
        return Map.of(
                "health", service.getHealth(),
                "memory", service.getMetrics("jvm.memory.used"),
                "cpu", service.getMetrics("system.cpu.usage"),
                "uptime", service.getMetrics("process.uptime"),
                "http", service.getMetrics("http.server.requests")
        );
    }
}
