package com.demoqa.practiceform.testdata;

public enum Subject {
        MATH("Maths"),
        COMPUTER("Computer Science"),
        CHEMISTRY("Chemistry"),
        COMMERCE("Commerce"),
        ACCOUNTING("Accounting"),
        ECONOMICS("Economics"),
        SOCIAL_STUDIES("Social Studies"),
        CIVICS("Civics"),
        BIOLOGY("Biology"),
        HISTORY("History"),
        PHYSICS("Physics");

        public String title;

        Subject(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
}
