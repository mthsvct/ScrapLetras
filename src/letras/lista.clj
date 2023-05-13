(ns letras.lista (:gen-class) (:require [net.cgrand.enlive-html :as html]))

(defn pegaLink [item] (str "https://www.letras.mus.br" (get (get item :attrs) :href)))

(defn pegaTitulo [item] (first (get (first (get item :content)) :content)))

(defn montaMap [item] {:link (pegaLink item) :titulo (pegaTitulo item)})

(defn pegaLista [ht] (map #(montaMap %) (html/select ht [:a.song-name])))