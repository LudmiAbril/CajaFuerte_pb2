package ar.edu.unlam.pb2;

public class CajaFuerte {
	private Boolean abierta;
	private Integer codigo;
	private Integer contador;
	private Integer masterKey;

	public CajaFuerte(Integer masterKey) {
		this.abierta = true;
		this.contador = 0;
		this.masterKey = masterKey;
	}

	public Boolean estaAbierta() {
		return this.abierta;
	}

	public void cerrar(Integer codigo) {
		this.codigo = codigo;
		this.abierta = false;

	}

	public void abrir(Integer codigo) {
		if (codigo.equals(this.codigo) && !estaBloqueada()) {
			this.abierta = true;
			this.contador = 0;
		} else {
			this.contador++;
		}

	}

	public Boolean estaBloqueada() {
		if (this.contador == 3) {
			return true;
		}
		return false;
	}

	public void Desbloquear(Integer masterKey) {
		if (this.masterKey.equals(masterKey)) {
			this.contador = 0;
		}

	}

}
