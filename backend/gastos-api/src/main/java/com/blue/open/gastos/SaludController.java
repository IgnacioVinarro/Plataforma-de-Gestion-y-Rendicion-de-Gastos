package com.blue.open.gastos;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludController {

	@GetMapping("/api/salud")
	public Map<String, String> verificarSalud() {
		return Map.of("estado", "ok");
	}

}