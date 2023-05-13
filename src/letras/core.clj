(ns letras.core
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]))

(defn -main
	"I don't do a whole lot ... yet."
	[& args]
	(let [
		url (do (print "Digite a url do artista do site letras: ") 
				(flush) 
				(read-line))
		html (pegaHTML url)
		artist (getName html)] 
		
		(println artist)))
