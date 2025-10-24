class PasswordChecker {
    private Integer minLength;
    private Integer maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений должно быть положительным числом");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        // Проверяем, что настройки установлены
        if (minLength == null || maxRepeats == null) {
            throw new IllegalStateException("Не все настройки проверки установлены");
        }

        // Проверка минимальной длины
        if (password.length() < minLength) {
            return false;
        }

        // Проверка повторений
        int currentRepeats = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                currentRepeats++;
                if (currentRepeats > maxRepeats) {
                    return false;
                }
            } else {
                currentRepeats = 1;
            }
        }

        return true;
    }
}
