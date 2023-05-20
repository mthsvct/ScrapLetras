(ns letras.artista (:gen-class) (:require [net.cgrand.enlive-html :as html]))

(defn getName [html] (first (get (first (html/select html [:div.cnt-head_title :h1])) :content)))


