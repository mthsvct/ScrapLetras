(ns letras.pagina (:gen-class) 
    (:require 
        [net.cgrand.enlive-html :as html]))

(defn fetch-page [url] (html/html-resource (java.net.URL. url)))

(defn pegaHTML [url] (fetch-page url))