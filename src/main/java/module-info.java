module arcadia.aegis {
    requires hanyaeger;
    requires com.google.guice;

    exports org.arcadia.aegis;

    opens backgrounds;
    opens sounds;
    opens sprites;
    opens images;
}
