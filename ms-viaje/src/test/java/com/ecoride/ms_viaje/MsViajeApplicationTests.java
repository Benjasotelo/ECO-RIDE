package com.ecoride.ms_viaje;

import com.ecoride.ms_viaje.repository.ViajeRepository;
import com.ecoride.ms_viaje.service.ViajeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MsViajeApplicationTests {

	@Mock
	private ViajeRepository viajeRepository;

	@InjectMocks
	private ViajeService viajeService;

	@Test
	void cuandoCrearViaje_entoncesRetornaViajeCreado() {
	}
}