package ua.edu.znu.flags;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Перелік країн, прапори яких використовуються у грі.
 * Кожен елемент інкапсулює ім'я ресурсу зображення прапора та назву країни,
 * що дозволяє уникнути жорсткого кодування шляхів і назв у класі Flags.
 */
public enum FlagCountry {

    FRANCE("france.gif", "Франція"),
    GERMANY("germany.gif", "Німеччина"),
    SWEDEN("sweden.gif", "Швеція"),
    BELGIUM("belgium.gif", "Бельгія");

    private static final String IMAGES_PATH = "/images/";

    private final String iconName;
    private final String countryName;

    FlagCountry(final String iconName, final String countryName) {
        this.iconName = iconName;
        this.countryName = countryName;
    }

    /**
     * Повертає назву країни українською.
     *
     * @return назва країни
     */
    public String countryName() {
        return countryName;
    }

    /**
     * Завантажує іконку прапора з ресурсного каталогу проекту.
     *
     * @return іконка прапора
     * @throws IllegalStateException якщо ресурс не знайдено
     */
    public ImageIcon loadIcon() {
        URL url = FlagCountry.class.getResource(IMAGES_PATH + iconName);
        if (url == null) {
            throw new IllegalStateException("Ресурс не знайдено: " + iconName);
        }
        return new ImageIcon(url);
    }
}
