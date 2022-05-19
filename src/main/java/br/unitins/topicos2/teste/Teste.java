package br.unitins.topicos2.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.unitins.topicos2.model.Pais;
import br.unitins.topicos2.utils.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		List<String> paises = new ArrayList<String>();
		
		paises.add("Afeganist�o"
				+ "�frica do Sul"
				+ "Alb�nia"
				+ "Alemanha"
				+ "Andorra"
				+ "Angola"
				+ "Antiga e Barbuda"
				+ "Ar�bia Saudita"
				+ "Arg�lia"
				+ "Argentina"
				+ "Arm�nia"
				+ "Austr�lia"
				+ "�ustria"
				+ "Azerbaij�o"
				+ "Bahamas"
				+ "Bangladexe"
				+ "Barbados"
				+ "Bar�m"
				+ "B�lgica"
				+ "Belize"
				+ "Benim"
				+ "Bielorr�ssia"
				+ "Bol�via"
				+ "B�snia e Herzegovina"
				+ "Botsuana"
				+ "Brasil"
				+ "Brunei"
				+ "Bulg�ria"
				+ "Burquina Faso"
				+ "Bur�ndi"
				+ "But�o"
				+ "Cabo Verde"
				+ "Camar�es"
				+ "Camboja"
				+ "Canad�"
				+ "Catar"
				+ "Cazaquist�o"
				+ "Chade"
				+ "Chile"
				+ "China"
				+ "Chipre"
				+ "Col�mbia"
				+ "Comores"
				+ "Congo-Brazzaville"
				+ "Coreia do Norte"
				+ "Coreia do Sul"
				+ "Cosovo"
				+ "Costa do Marfim"
				+ "Costa Rica"
				+ "Cro�cia"
				+ "Cuaite"
				+ "Cuba"
				+ "Dinamarca"
				+ "Dominica"
				+ "Egito"
				+ "Emirados �rabes Unidos"
				+ "Equador"
				+ "Eritreia"
				+ "Eslov�quia"
				+ "Eslov�nia"
				+ "Espanha"
				+ "Essuat�ni"
				+ "Estado da Palestina"
				+ "Estados Unidos"
				+ "Est�nia"
				+ "Eti�pia"
				+ "Fiji"
				+ "Filipinas"
				+ "Finl�ndia"
				+ "Fran�a"
				+ "Gab�o"
				+ "G�mbia"
				+ "Gana"
				+ "Ge�rgia"
				+ "Granada"
				+ "Gr�cia"
				+ "Guatemala"
				+ "Guiana"
				+ "Guin�"
				+ "Guin� Equatorial"
				+ "Guin�-Bissau"
				+ "Haiti"
				+ "Honduras"
				+ "Hungria"
				+ "I�men"
				+ "Ilhas Marechal"
				+ "�ndia"
				+ "Indon�sia"
				+ "Ir�o"
				+ "Iraque"
				+ "Irlanda"
				+ "Isl�ndia"
				+ "Israel"
				+ "It�lia"
				+ "Jamaica"
				+ "Jap�o"
				+ "Jibuti"
				+ "Jord�nia"
				+ "Laus"
				+ "Lesoto"
				+ "Let�nia"
				+ "L�bano"
				+ "Lib�ria"
				+ "L�bia"
				+ "Listenstaine"
				+ "Litu�nia"
				+ "Luxemburgo"
				+ "Maced�nia do Norte"
				+ "Madag�scar"
				+ "Mal�sia"
				+ "Mal�ui"
				+ "Maldivas"
				+ "Mali"
				+ "Malta"
				+ "Marrocos"
				+ "Maur�cia"
				+ "Maurit�nia"
				+ "M�xico"
				+ "Mianmar"
				+ "Micron�sia"
				+ "Mo�ambique"
				+ "Mold�via"
				+ "M�naco"
				+ "Mong�lia"
				+ "Montenegro"
				+ "Nam�bia"
				+ "Nauru"
				+ "Nepal"
				+ "Nicar�gua"
				+ "N�ger"
				+ "Nig�ria"
				+ "Noruega"
				+ "Nova Zel�ndia"
				+ "Om�"
				+ "Pa�ses Baixos"
				+ "Palau"
				+ "Panam�"
				+ "Papua Nova Guin�"
				+ "Paquist�o"
				+ "Paraguai"
				+ "Peru"
				+ "Pol�nia"
				+ "Portugal"
				+ "Qu�nia"
				+ "Quirguist�o"
				+ "Quirib�ti"
				+ "Reino Unido"
				+ "Rep�blica Centro-Africana"
				+ "Rep�blica Checa"
				+ "Rep�blica Democr�tica do Congo"
				+ "Rep�blica Dominicana"
				+ "Rom�nia"
				+ "Ruanda"
				+ "R�ssia"
				+ "Salom�o"
				+ "Salvador"
				+ "Samoa"
				+ "Santa L�cia"
				+ "S�o Crist�v�o e Neves"
				+ "S�o Marinho"
				+ "S�o Tom� e Pr�ncipe"
				+ "S�o Vicente e Granadinas"
				+ "Seicheles"
				+ "Senegal"
				+ "Serra Leoa"
				+ "S�rvia"
				+ "Singapura"
				+ "S�ria"
				+ "Som�lia"
				+ "Sri Lanca"
				+ "Sud�o"
				+ "Sud�o do Sul"
				+ "Su�cia"
				+ "Su��a"
				+ "Suriname"
				+ "Tail�ndia"
				+ "Taiu�"
				+ "Tajiquist�o"
				+ "Tanz�nia"
				+ "Timor-Leste"
				+ "Togo"
				+ "Tonga"
				+ "Trindade e Tobago"
				+ "Tun�sia"
				+ "Turcomenist�o"
				+ "Turquia"
				+ "Tuvalu"
				+ "Ucr�nia"
				+ "Uganda"
				+ "Uruguai"
				+ "Usbequist�o"
				+ "Vanuatu"
				+ "Vaticano"
				+ "Venezuela"
				+ "Vietname"
				+ "Z�mbia"
				+ "Zimb�bue");
		System.out.println(paises.size());
		for (int j = 0; j < paises.size(); j++) {
			//TypedQuery<Pais> query = JPAUtil.getEntityManager().createQuery("INSERT INTO pais(nome) VALUES(?)", Pais.class);
			//query.setParameter("?", paises.get(j));
		}

	}

}