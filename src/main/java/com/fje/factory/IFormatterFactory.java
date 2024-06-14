package com.fje.factory;

import com.fje.component.Formatter;

public interface IFormatterFactory {
    Formatter createFormatter();
    Formatter createFormatter(String icon);
}
