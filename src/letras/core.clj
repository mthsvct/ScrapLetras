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


(defn menu []
	(println)
	(println "1 - Imprimir em Pre-Ordem")
	(println "2 - Imprimir em In-Ordem")
	(println "3 - Imprimir em Pos-Ordem")
	(println "4 - Imprimir em In-Ordem Reverse")
	(println "0 - Sair")
	(print "Digite uma opcao: ")
	(flush)
	(Integer/parseInt (read-line)))

(defn escolhe [raiz op] 
	(cond
		(= op 1)   (do (gestaoShow raiz 1) (escolhe raiz (menu)))
		(= op 2)   (do (gestaoShow raiz 2) (escolhe raiz (menu)))
		(= op 3)   (do (gestaoShow raiz 3) (escolhe raiz (menu)))
		(= op 4)   (do (gestaoShow raiz 4) (escolhe raiz (menu)))
		(= op 0)   (do (println "Saindo...") raiz)
		:else      (do (println "Opcao invalida!") (escolhe raiz (menu)))))



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
			(abrirPasta artist pasta)
			(salvaLista semRepeat pasta)
			(escolhe (pegaLetras semRepeat pasta nil) (menu))
			; fazer a parte da leitura e da criação da árvore	
			; ler o arquivo
		)))

; Fazer uma função que busca uma palavra apresenta: Quantas vezes ela aparece e em qual músicas a música aparece.
; Fazer uma função que busca quais as 10 palavras mais frequentes.
; Fazer uma função que apresenta a quantidade de músicas
; Fazer uma função que salva estatísticas de palavras em um arquivo csv
