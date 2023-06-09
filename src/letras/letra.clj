(ns letras.letra
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]
		[letras.lista :refer :all]
        [clojure.string :as str]
		[net.cgrand.enlive-html :as html]
		[letras.arvore :refer :all]
		[letras.palavras :refer :all]
		))

; Primeiro pegar o HTML da página
; Depois pegar o nome da música
; Gerar o nome do arquivo com o nome da música onde o espaço é _
; Depois pegar a letra da música
; Depois salvar a letra da música no arquivo

(defn pegaLetra [page] (map #(get % :content) (html/select page [:div.cnt-letra :p])))

(defn filtra [l] (filter #(= (class %) java.lang.String) l))

(defn extrair [lista] (map filtra lista))

(defn aplicaEnter [lista] (if (empty? lista) "\n" (str (first lista) "\n" (aplicaEnter (rest lista)))))

(defn estrofe [lista] (map #(aplicaEnter %) lista))

(defn lyric [page] (estrofe (extrair (pegaLetra page))))

(defn mainLetra [musica pasta raiz] 
	(let 

		[	url (str (get musica :link))
			titulo (get musica :titulo)
			arquivo (str pasta "/lyrics/" (clojure.string/replace titulo #" " "_") ".txt")
			page (pegaHTML url)
			letra (str/join "" (lyric page))
			listaWords (pegaPalavras letra)
			
			]

		(do 
			(println listaWords)
			(spit arquivo (str titulo "\n\n" letra)))))

; Apresentar em qual música está tipo 1/100...4/100
(defn pegaLetras [lista pasta raiz] 
	(doseq [musica lista] 
		(mainLetra musica pasta raiz)
		(println 
			(str 
				"Letra da música " (get musica :titulo) " salva com sucesso!"))))
