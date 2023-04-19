package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testqueSeAlCrearseLaCajaFuerteEsteAbierta() {
		CajaFuerte caja = new CajaFuerte(2246);
		assertTrue(caja.estaAbierta());
	}

	@Test
	public void queSeCierreLaCajaALIngresarElCodigo() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		assertFalse(caja.estaAbierta());
	}
	
	@Test
	public void queSePuedaAbrirLaCajaAlIngresarElCodigoCorrecto() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		caja.abrir(1234);
		assertTrue(caja.estaAbierta());
	}
	
	@Test
	public void queNoSePuedaAbrirLaCajaAlIngresarUnCodigoIncorrecto() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		caja.abrir(1235);
		assertFalse(caja.estaAbierta());
	}
	
	@Test
	public void queSeBloqueeLaCajaConTresIntentosFallidos() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		caja.abrir(1235);
		caja.abrir(1235);
		caja.abrir(1235);
		
		assertTrue(caja.estaBloqueada());
	}
	
	@Test
	public void queNoSePuedaAbrirLaCajaBloqueadaAunqueSeIngreseElCodigoCorrecto() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		caja.abrir(1235);
		caja.abrir(1235);
		caja.abrir(1235);
		caja.abrir(1234);
		
		assertFalse(caja.estaAbierta());
	}
	
	@Test
	public void queSeDesbloqueeLaCajaAlIngresarUnaMasterKey() {
		CajaFuerte caja = new CajaFuerte(2246);
		caja.cerrar(1234);
		caja.abrir(1235);
		caja.abrir(1235);
		caja.abrir(1235);
		caja.Desbloquear(2246);
		
		assertFalse(caja.estaBloqueada());
	}

}
