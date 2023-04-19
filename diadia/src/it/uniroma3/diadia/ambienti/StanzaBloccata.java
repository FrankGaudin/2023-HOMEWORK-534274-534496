package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	
	private String pass;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String pass) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.pass = pass;
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "C'è una stanza bloccata a: " + direzioneBloccata +"\nProva a posare: " + pass;
		
		if(!this.hasAttrezzo(pass))
			return bloccata;
		return super.getDescrizione();
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(pass)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

}
