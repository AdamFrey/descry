(ns descry.dev.dbmock)

(def offline-data
  [{:db/id                         -31
    :listing/name                  "Mill Creek Fields & Beech Bluffs"
    :listing/general-property-name "Cate's Land"
    :listing/local-area-name       "Alamance County"
    :listing/slug                  "north-carolina/cate_s-land/mill-creek-field-_and_-beech-bluffs"
    :listing/summary               "A unique property with open meadows, forests and a stream that runs through it."
    :listing/description           "The 25 acre Charles R. Keith Arboretum site
hosts one of the largest plant collections of temperate woody species
in North America, containing approximately 4000 labeled species. The
balance of this property is wooded with a variety of piedmont hardwood
and pine forest situated on a rolling landscape with seemingly endless
opportunities to explore and learn. Stand small next to the largest
Redwood on the East Coast, or picnic under a 100 year old
Magnolia. Campfires, picnics, and peaceful strolls make this the only
experience of its kind for hundreds of miles around."
    :listing/activities            [-6 -8 -10 -2 -4 -5]
    :listing/amenities             [-22 -17]
    :listing/location              {:location/latitude  36.1187706
                                    :location/longitude -79.2734411}
    :listing/thumbnail             {:meda/url "//images.contentful.com/t1v7pm9kir1q/27gZAUegvqqqgCAYeeKmMG/1b690fba97ef48e0b62605c8eac5dbdb/Mill-Creek-Fields-___-Beech-Bluffs-10.jpg"}
    :listing/banner-image          {:media/url "//images.contentful.com/t1v7pm9kir1q/27x0OHAAQwM0U86S8kcUc2/6d6c71e5f2e8e550995919ebeae3de82/Mill-Creek-Fields-___-Beech-Bluffs-12.jpg"}
    :listing/media                 [{:media/url "//images.contentful.com/t1v7pm9kir1q/71IEEG3nTUy2OAas8Wg42S/93f283e11948b20667db17618e140b04/Mill-Creek-Fields-___-Beech-Bluffs-1.jpg"}
                                    {:media/url "//images.contentful.com/t1v7pm9kir1q/3o8s72Uvp6wOWiA6WysqcM/69bdb7073b6d3b84246a283d92851780/Mill-Creek-Fields-___-Beech-Bluffs-2.jpg"}]
    :price/per-user                500}

   {:listing/name                  "Keith Arboretum"
    :listing/general-property-name "Pickoretum"
    :listing/local-area-name       "Orange County"
    :listing/slug                  "north-carolina/pickoretum/keith-arboretum"
    :listing/summary               "A hidden world-class arboretum nestled in 150 acres of private forest"
    :listing/description           "The Cates Property is a one of a kind
    opportunity to experience open space, forests and streams all on
    one property. Bring your family, friends and even pets to this
    property and enjoy a great hike along Mill Creek and eventually
    you will find the hidden treasure of the Cates Property which are
    its magnificent Beech Bluffs right near a bed in the creek. Enjoy
    birding, hiking, camping, fishing and even drone flying out in the
    10+ acres of open meadows. The Cates Property is just a short 30
    minute drive from Durham. Reserve the Cates Property now and have
    your day in the sunshine!"
    :listing/activities            [-10 -4 -9 -6 -5 -7]
    :listing/amenities             [-25 -19 -20 -22 -18]
    :listing/location              {:location/latitude  35.9608891
                                    :location/longitude -79.1454589}
    :listing/thumbnail             {:media/url "//images.contentful.com/t1v7pm9kir1q/4BLsP0ns7CqoMas8EgUwGi/08f76b94d684d791fdd1ca785e1ed6f2/Pickoretum-Pond.JPG"}
    :listing/banner-image          {:media/url "//images.contentful.com/t1v7pm9kir1q/4bxEndKrDOwc8okYQWa64q/9217b7bcd355792e10289c23a96eef34/pickoretum-property-banner.jpg"}
    :listing/media                 [{:media/url "//images.contentful.com/t1v7pm9kir1q/4kuLp5nKGsO4iCuQIuWaa2/8711dfd195f8b3609a2c1b1db74bf1eb/Pickoretum-Forest.JPG"}
                                    {:media/url "//images.contentful.com/t1v7pm9kir1q/4P0wImDvbiYAmwgwouCMwy/f1c93fdc05de3628c2fbff12e1dc074f/Pickoretum-Forest2.JPG"}]}

   ;; User
   {:db/uuid #uuid "8d1fa862-7f6b-42c3-a3c5-b7864a22fb6d"}
   ;; Other User
   {:db/uuid #uuid "9d1fa862-7f6b-42c3-a3c5-b7864a22fb6d"}

   {:blackout/start   (js/Date. "2017-01-07T11:30")
    :blackout/end     (js/Date. "2017-01-20")
    :blackout/listing -31}

   {:waiver/text     "This is the waiver"
    :waiver/default? true}

   {:payment/brand         "Visa"
    :payment/last-4-digits "5432"
    :payment/saved?        true}

   {:page/name               :land-sharing
    :page/title              "List your land"
    :page/banner-url         "//images.contentful.com/t1v7pm9kir1q/mPRbHYeH3EoQW2gksaiie/998b5b1690a158461a75aa940f63138e/dscn1058_26878608153_o.jpg"
    :page/banner-heading     "Be a host for the great outdoors"
    :page/banner-sub-heading "Make money while you sleep"
    :page/call-to-action     "List Your Land"
    :page/content            "##How Land Listing Works
#####Step 1 →
#Sign up to host
###Create a profile page for your land."}

   {:page/name           :about
    :page/banner-heading "A New Way to Play"
    :page/banner-url     "//images.contentful.com/t1v7pm9kir1q/3gEelc4XhKGkyOieMoy6Oy/dda13293976486e51aa09c9fd28c5e1d/iStock_000081023507_Large.jpg"
    :page/content        "#About Rōmr
Rōmr connects people to unique and exclusive outdoor experiences in their immediate community. With our online reservation system and the commitment and engagement of private landowners, Rōmr permits anyone to reserve any private land for any outdoor use. Once it’s reserved, it’s just you and the great outdoors."}

   {:page/name           :contact
    :page/banner-heading "Get in touch"
    :page/banner-url     "//images.contentful.com/t1v7pm9kir1q/6akdyLP93qkO2OGI4EOCO8/ae3fb349a490cbb5373109f2033f55e5/iStock_000062572542_Large.jpg"
    :page/content        "For questions about or help using romr.com:
support@romr.com

For general inquiries (partnerships, press, etc):
info@romr.com

Give us a call:
919-391-9164"}])

(def mock-data
  (-> [#_{:db/id                 -1
          :activity/name         :activity/atv-riding
          :activity/display-name "ATV Riding"
          :contentful-id         "5SSAa7McJqe66aywGUEaaG"}
       {:db/id         -2
        :activity/name :activity/birding
        :contentful-id "f4dKyOnPRQcoGOOGWWKYu"}
       {:db/id         -3
        :activity/name :activity/bonfire
        :contentful-id "24sP8wRXtGGcAKKUUYG8qS"}
       {:db/id                 -4
        :activity/name         :activity/camping
        :activity/display-name "Camping"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/5iv8b5ZpTy6kSMEYOawkuS/5af493668872ad7a0cf7b0b6e4087496/Private-Camping-green-tent.jpg"
        :contentful-id         "5jEToRTruEyqWy8UmUwewE"}
       {:db/id                 -5
        :activity/name         :activity/dog-walking
        :activity/display-name "Off-Leash Dog Walking"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/1qAjpCVaAYA4YQmkWqymiG/08fd5091960cc3ed70ee14590832e58a/dogtrail.jpg"
        :contentful-id         "7Eqq1OtPKEqss6WeME2kE"}
       {:db/id                 -6
        :activity/name         :activity/drone-flying
        :activity/display-name "Drone Flying"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/3yY3JFfpagMkK6gWIccQc/ff04d85f393c92a6ef5f05411886c361/Drone-Flying-two-men-in-field.jpg"
        :contentful-id         "16ZYMOznBkqUOGmwSAkC64"}
       {:db/id         -7
        :activity/name :activity/events
        :activity/display-name "Events"
        :contentful-id "2PxuIVvB8sGwuSUw2qomqs"}
       {:db/id                 -8
        :activity/name         :activity/fishing
        :activity/display-name "Fishing"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/2TNhzeiw8w4EWEuqeGEWWm/2812d58078a219119d06ba91d9aa73e8/Fishing-solo-pond.jpg"
        :contentful-id         "4aHOalishyyu2mWkGAgy6i"}
       {:db/id                 -9
        :activity/name         :activity/foraging
        :activity/display-name "Foraging"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/3uJ9XldeOcaYkmqqm4UwYm/bec27062305ce1c0f5a0dd9b54ece1b0/Foraging-blueberries.jpg"
        :contentful-id         "35L86KxbZeEomwGSYukOgS"}
       {:db/id                 -10
        :activity/name         :activity/hiking
        :activity/display-name "Hiking"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/2zC6rS82feKWsOokeuEkU4/c7a6ac68fbed8e72092bd6dfe2ce6d6d/Events-group-in-woods.jpg"
        :contentful-id         "6NuW8e0Q6scQUWCC0ygkKG"}
       {:db/id                 -11
        :activity/name         :activity/kayaking-canoeing
        :activity/display-name "Kayaking & Canoeing"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/16CAhT7ymc00qyueeGQgAu/ab2e973ad7e9a6105f580603c0f22158/Kayaking-and-Canoeing-green-canoe.jpg"
        :contentful-id         "2RPhYIkO7muGW0AWi6U8GS"}
       {:db/id                 -12
        :activity/name         :activity/mountain-biking
        :activity/display-name "Mountain Biking"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/10RmGCvcScKOsmQSiky4Q6/36f1470a0fb1e7bf4a5179b174d67a60/Mountain-Biking-racing-through-woods-filter-optimized.jpg"
        :contentful-id         "3Um9giCvziOOqi2MeYIYcO"}
       {:db/id         -13
        :activity/name :activity/paddleboarding
        :activity/display-name "Paddleboarding" 
        :contentful-id "3D7UWpQfsAQiKseQwc4mOw"}
       #_{:db/id         -14
          :activity/name :activity/small-game-hunting}
       {:db/id                 -15
        :activity/name         :activity/swimming
        :activity/display-name "Swimming"
        :activity/photo        "//images.contentful.com/t1v7pm9kir1q/XOlRQCM7kGOacAEC8y06i/7580664bd09f3543eb148af6544f2ac1/Swimming-jumping-into-lake.jpg"
        :contentful-id         "3TAClglDMQaQ4GO04maScY"}
       {:db/id         -16
        :activity/name :activity/target-shooting
        :contentful-id "6gdRnxEalywwYuqQWq48Me"}

       {:db/id         -17
        :amenity/name :amenity/cell-reception
        :amenity/display-name "Cell Reception"
        :contentful-id "3BQpw56WM8uacMmqagOyEe"}
       {:db/id         -19
        :amenity/name :amenity/electricity
        :amenity/display-name "Electricity"
        :contentful-id "460VsrotqwoYSEQ2kSoc6A"}
       {:db/id         -18
        :amenity/name :amenity/drinking-water
        :amenity/display-name "Drinking Water"
        :contentful-id "3O8A007pAIwWQ2Iu2uYGW2"}
       {:db/id         -20
        :amenity/name :amenity/gated-property
        :amenity/display-name "Gated property"
        :contentful-id "1tc60rrBw8GymoaAmMAika"}
       {:db/id         -21
        :amenity/name :amenity/outdoor-grill
        :amenity/display-name "Outdoor grill"
        :contentful-id "3iSPVnlZCwqQWWoCiGkaIA"}
       {:db/id         -23
        :amenity/name :amenity/picnic-tables
        :amenity/display-name "Picnic tables"
        :contentful-id "4iCAyhBrCgQ2sySCOS26co"}
       {:db/id         -24
        :amenity/name :amenity/restrooms
        :amenity/display-name "Restrooms"
        :contentful-id "5AgVcWwQMwuOogOoki48uu"}
       {:db/id         -25
        :amenity/name :amenity/shelter
        :amenity/display-name "Shelter"
        :contentful-id "6swpoXgNBCkMGCEqEs40E2"}
       {:db/id         -26
        :amenity/name :amenity/wheelchair-accessible
        :amenity/display-name "Accessible"
        :contentful-id "1oESsO9JAw66qqkSyqQu8M"}

       #_{:db/uuid           #uuid "3253d211-925c-4204-bad7-bfad9fa2c79b"
        :contentful-id     "VKB9VBcbUQksg4G6YsYio"
        :event/name        "Neo-Luddites Meeting"
        :price/per-user    1000
        :event/description "Let's go out and enjoy a walk at the beautiful Pickoretum- where Pickard's Mountain meets the Keith Arboretum. It's an out an back trail of about 2 miles, and we can take a 1 mile lap around the Keith Arboretum afterwards.

Dogs can be off leash. However, if a guest or parent asks you to put your dog on a leash, please do so. This is not an exclusively off leash event."
        :event/check-in-time  (js/Date. "2017-02-23T11:30")
        :event/check-out-time (js/Date. "2017-02-23T14:30")
        :event/thumbnail      {:media/url "http://lorempixel.com/200/200"}
        :event/banner-image   {:media/url "//images.contentful.com/t1v7pm9kir1q/27x0OHAAQwM0U86S8kcUc2/6d6c71e5f2e8e550995919ebeae3de82/Mill-Creek-Fields-___-Beech-Bluffs-12.jpg"}}])
  #_(concat offline-data))
