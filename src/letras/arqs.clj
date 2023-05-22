(ns letras.arqs
	(:gen-class)
	(:require 
		[letras.artista :refer :all]
		[letras.pagina :refer :all]
		[letras.lista :refer :all]
        [clojure.string :as str]))


(defn abrirPasta [artist] (.mkdir (java.io.File. (str "src/data/" (clojure.string/replace artist #" " "_")))))

(defn separa [artist] (println (str/split artist #" ")))