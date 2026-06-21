package com.ecoride.ms_usuario;

import com.ecoride.ms_usuario.dto.UsuarioResponseDTO;
import com.ecoride.ms_usuario.model.Usuario;
import com.ecoride.ms_usuario.repository.UsuarioRepository;
import com.ecoride.ms_usuario.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MsUsuarioApplicationTests {

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UsuarioService usuarioService;

	@Test
	void cuandoGuardarUsuario_entoncesRetornaUsuarioResponseDTO() {
		// 1. GIVEN (Preparar los datos de prueba)
		Usuario usuarioEntrada = new Usuario();
		usuarioEntrada.setNombreUsuario("vthomas");
		usuarioEntrada.setCorreoElectronico("victor@ecoride.cl");
		usuarioEntrada.setRol("CLIENTE");

		Usuario usuarioGuardado = new Usuario();
		usuarioGuardado.setId(1L);
		usuarioGuardado.setNombreUsuario("vthomas");
		usuarioGuardado.setCorreoElectronico("victor@ecoride.cl");
		usuarioGuardado.setRol("CLIENTE");
		usuarioGuardado.setActivo(true); // El servicio lo cambia a true

		// Simulamos el comportamiento del JpaRepository
		when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado);

		// 2. WHEN (Ejecutar el método real de tu servicio)
		UsuarioResponseDTO resultado = usuarioService.guardar(usuarioEntrada);

		// 3. THEN (Verificar los resultados esperados)
		assertNotNull(resultado);
		assertEquals(1L, resultado.getId());
		assertEquals("vthomas", resultado.getNombreUsuario());
		assertTrue(resultado.getActivo());

		// Verificamos que se llamó al repositorio exactamente 1 vez
		verify(usuarioRepository, times(1)).save(any(Usuario.class));
	}

	@Test
	void cuandoObtenerPorIdExistente_entoncesRetornaUsuarioResponseDTO() {
		// 1. GIVEN
		Long usuarioId = 1L;
		Usuario usuarioSimulado = new Usuario();
		usuarioSimulado.setId(usuarioId);
		usuarioSimulado.setNombreUsuario("vthomas");
		usuarioSimulado.setCorreoElectronico("victor@ecoride.cl");
		usuarioSimulado.setRol("CLIENTE");
		usuarioSimulado.setActivo(true);

		when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.of(usuarioSimulado));

		// 2. WHEN
		UsuarioResponseDTO resultado = usuarioService.obtenerPorId(usuarioId);

		// 3. THEN
		assertNotNull(resultado);
		assertEquals(usuarioId, resultado.getId());
		assertEquals("vthomas", resultado.getNombreUsuario());

		verify(usuarioRepository, times(1)).findById(usuarioId);
	}
}