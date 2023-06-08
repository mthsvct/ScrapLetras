(ns letras.core
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]
		[letras.lista :refer :all]
		[letras.arqs :refer :all]
		[letras.letra :refer :all]
		[letras.arvore :refer :all]
		))

(defn -main
	"I don't do a whole lot ... yet."
	[& args]
	(let [
		;; url (do (print "Digite a url do artista do site letras: ") 
		;; 		(flush) 
		;; 		(read-line))
		url "https://www.letras.mus.br/lana-del-rey/"
		html (pegaHTML url)
		artist (getName html)
		listaMusics (pegaLista html)
		semRepeat (apagaRepetido listaMusics)
		pasta (str "src/data/" (clojure.string/replace artist #" " "_"))
		raiz nil
		] 
		(do
			(abrirPasta artist pasta)
			(salvaLista semRepeat pasta)
			(pegaLetras semRepeat pasta)
			; fazer a parte da leitura e da criação da árvore	
			; ler o arquivo
		)))


; Criar uma pasta: (.mkdir (java.io.File. "src/data/chico"))
; Criar um arquivo: (spit nameArq (str titulo "\n\n\n" (apply str letra)))