(ns descry.dev.rschema)

(def schema
  {:state/part {:db/unique :db.unique/identity}

   :db/uuid {:db/unique :db.unique/identity}

   :activity/name               {:db/cardinality :db.cardinality/one}
   :activity/display-name       {:db/cardinality :db.cardinality/one}
   :activity/photo              {:db/cardinality :db.cardinality/one}
   :activity/user-filtering-by? {:db/cardinality :db.cardinality/one}

   :amenity/name               {:db/cardinality :db.cardinality/one}
   :amenity/display-name       {:db/cardinality :db.cardinality/one}
   :amenity/user-filtering-by? {:db/cardinality :db.cardinality/one}

   :media/url {:db/cardinality :db.cardinality/one}

   :listing/name                  {:db/cardinality :db.cardinality/one}
   :listing/general-property-name {:db/cardinality :db.cardinality/one}
   :listing/slug                  {:db/cardinality :db.cardinality/one}
   :listing/summary               {:db/cardinality :db.cardinality/one}
   :listing/description           {:db/cardinality :db.cardinality/one}
   :listing/recommendations       {:db/cardinality :db.cardinality/one}
   :listing/activities            {:db/cardinality :db.cardinality/many
                                   :db/valueType   :db.type/ref}
   :listing/amenities             {:db/cardinality :db.cardinality/many
                                   :db/valueType   :db.type/ref}
   :listing/location              {:db/cardinality :db.cardinality/one
                                   :db/valueType   :db.type/ref}
   :listing/latitude              {:db/cardinality :db.cardinality/one}
   :listing/longitude             {:db/cardinality :db.cardinality/one}
   :listing/thumbnail             {:db/valueType :db.type/ref}
   :listing/banner-image          {:db/valueType :db.type/ref}
   :listing/media                 {:db/cardinality :db.cardinality/many
                                   :db/valueType   :db.type/ref}
   :listing/reviews               {:db/cardinality :db.cardinality/many
                                   :db/valueType   :db.type/ref}

   :listing/blackouts {:db/cardinality :db.cardinality/many
                       :db/valueType   :db.type/ref}

   :blackout/start   {:db/cardinality :db.cardinality/one}
   :blackout/end     {:db/cardinality :db.cardinality/one}
   :blackout/listing {:db/cardinality :db.cardinality/many
                      :db/valueType   :db.type/ref}

   :event/thumbnail    {:db/valueType :db.type/ref}
   :event/banner-image {:db/valueType :db.type/ref}
   :event/listing      {:db/valueType :db.type/ref}
   :event/owner        {:db/valueType :db.type/ref}
   :event/outings      {:db/valueType   :db.type/ref
                        :db/cardinality :db.cardinality/many}
   :event/activities   {:db/valueType   :db.type/ref
                        :db/cardinality :db.cardinality/many}


   :outing/check-in-time  {:db/cardinality :db.cardinality/one}
   :outing/check-out-time {:db/cardinality :db.cardinality/one}
   :outing/name           {:db/cardinality :db.cardinality/one}
   :outing/listing        {:db/cardinality :db.cardinality/one
                           :db/valueType   :db.type/ref}
   :outing/activities     {:db/cardinality :db.cardinality/many
                           :db/valueType   :db.type/ref}
   :outing/overnight?     {:db/cardinality :db.cardinality/one}
   :outing/payment        {:db/cardinality :db.cardinality/one
                           :db/isComponent true
                           :db/valueType   :db.type/ref}
   :outing/user           {:db/valueType :db.type/ref}
   :outing/attendees      {:db/cardinality :db.cardinality/many
                           :db/valueType   :db.type/ref}
   :outing/event          {:db/valueType :db.type/ref}
   :outing/promos         {:db/cardinality :db.cardinality/many
                           :db/valueType   :db.type/ref}

   :user/location-name {:db/cardinality :db.cardinality/one}
   :user/activities    {:db/cardinality :db.cardinality/many
                        :db/valueType   :db.type/ref}

   :user/payment {:db/cardinality :db.cardinality/one
                  :db/valueType   :db.type/ref}

   :review/user {:db/cardinality :db.cardinality/one
                 :db/valueType   :db.type/ref}

   :page/banner {:db/cardinality :db.cardinality/one
                 :db/valueType   :db.type/ref}

   :invite/event {:db/valueType :db.type/ref}

   :contentful-id {:db/unique :db.unique/identity}

   ;; UI attrs
   :outing/in-progress        {:db/valueType :db.type/ref}
   :user/active               {:db/valueType :db.type/ref}
   :sign-up/user              {:db/valueType :db.type/ref}
   :page/viewing              {:db/valueType :db.type/ref}
   :outing/viewing            {:db/valueType :db.type/ref}
   :land-prospect/in-progress {:db/valueType :db.type/ref}
   :question/in-progress      {:db/valueType :db.type/ref}
   :listing/focused           {:db/valueType :db.type/ref}
   :listing/hovering          {:db/valueType :db.type/ref}})
