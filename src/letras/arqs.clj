(ns letras.arqs
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]
		[letras.lista :refer :all]
        [clojure.string :as str]))

(defn abrirPasta [artist pasta] (do (.mkdir (java.io.File. pasta)) (.mkdir (java.io.File. (str pasta "/lyrics")))))

(defn separa [artist] (str/split artist #" "))

(defn salva [conteudo arquivo] (spit arquivo conteudo))

(defn salvaLista [semRepeat pasta]
	(let [
		coluna1 "titulo;link\n"
		conteudo (apply str (map #(str %1 ";" %2 "\n") (map :titulo semRepeat) (map :link semRepeat)))
		]
		(salva (str coluna1 conteudo) (str pasta "/lista.csv"))))