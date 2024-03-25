package data.generator.config;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;

/**
 * Данный класс парсит XML и достает данные оттуда
 */
@RequiredArgsConstructor
public final class TextPath {

    private final XML xml;
    private final String node;

    @Override
    public String toString() {
        return this.xml
                .nodes(this.node)
                .get(0)
                .xpath("text()")
                .get(0);
    }
}
