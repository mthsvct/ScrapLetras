(ns letras.core
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]
		[letras.lista :refer :all]
		[letras.arqs :refer :all]))


(defn -main
	"I don't do a whole lot ... yet."
	[& args]
	(let [
		;; url (do (print "Digite a url do artista do site letras: ") 
		;; 		(flush) 
		;; 		(read-line))
		url "https://www.letras.mus.br/chico-science/"
		html (pegaHTML url)
		artist (getName html)
		listaMusics (pegaLista html)
		semRepeat (apagaRepetido listaMusics)
		pasta (str "src/data/" (clojure.string/replace artist #" " "_"))
		] 
		(do
			(println pasta)
			(abrirPasta artist)
			(separa artist) ; Separar o nome do artista em uma lista por spaço
			(println "Artista: " artist "\n\n" )
			(println (clojure.string/replace artist #" " "_") )
			;(showLista semRepeat)
			)))


; Criar uma pasta: (.mkdir (java.io.File. "src/data/chico"))
; Criar um arquivo: (spit nameArq (str titulo "\n\n\n" (apply str letra)))