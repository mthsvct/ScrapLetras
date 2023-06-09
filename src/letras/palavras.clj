(ns letras.palavras 
    (:gen-class) 
    (:require 
        [clojure.string :as str]
        [letras.arvore :refer :all]
        ))

(defn pegaPalavras [letra] 
    (filter 
        #(> (count %) 0) 
        (map
            #(-> %
                (str/replace #"[^a-zA-Z]" "")
                (str/lower-case))
            (str/split letra #"\s"))))

(defn inserirWords [lista raiz] (if (empty? lista) raiz (inserirWords (rest lista) (gestaoInsere raiz (first lista)) )))
    


