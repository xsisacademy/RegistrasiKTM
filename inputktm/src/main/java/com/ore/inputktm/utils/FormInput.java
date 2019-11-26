package com.ore.inputktm.utils;

public class FormInput {
    private static KTMModel dataModel;

    public static KTMModel getDataModel() {
        return dataModel;
    }

    public static void setDataModel(KTMModel dataModel) {
        FormInput.dataModel = dataModel;
    }
}
