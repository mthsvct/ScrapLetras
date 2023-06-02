(ns letras.lista (:gen-class) (:require [net.cgrand.enlive-html :as html]))

(defn pegaLink [item] (str "https://www.letras.mus.br" (get (get item :attrs) :href)))

(defn pegaTitulo [item] (first (get (first (get item :content)) :content)))

(defn montaMap [item] {:link (pegaLink item) :titulo (pegaTitulo item)})

(defn pegaLista [ht] (map #(montaMap %) (html/select ht [:a.song-name])))

(defn buscaNome [nome lista] (filter #(= (.toUpperCase nome) (.toUpperCase (get % :titulo))) lista))

(defn apagaRepetido [lista] 
    (if (empty? lista) []
        (if (= (count (buscaNome (get (first lista) :titulo) (rest lista))) 0)
            (cons (first lista) (apagaRepetido (rest lista)))
            (apagaRepetido (rest lista)))))

(defn showLista [lista] (doall (map #(println (get % :titulo ) "-" (get % :link ) ) lista)))
