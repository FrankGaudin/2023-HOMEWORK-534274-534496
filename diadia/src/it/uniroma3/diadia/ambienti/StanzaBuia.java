package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String attrezzoLanterna;
	
	public StanzaBuia(String nome, String attrezzoLanterna) {
		super(nome);
		this.attrezzoLanterna = attrezzoLanterna;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "qui c'è un buio pesto";
		if(!this.hasAttrezzo(attrezzoLanterna))
			return buio;
		return super.getDescrizione();
	}

}
