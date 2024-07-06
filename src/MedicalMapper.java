
public class MedicalMapper extends Laboratory implements Mapping, Comparable<MedicalMapper> {
    // we can get a specefic patient by his index of by his id;

    @Override
    public int mapBMI(double bmi) {
        int map;

        if (bmi > 0 && bmi < 18) {
            map = 0;
        } else if (bmi >= 18 && bmi < 25) {
            map = 1;
        } else if (bmi >= 25 && bmi < 30) {
            map = 2;
        } else if (bmi >= 30 && bmi <= 100) {
            map = 3;
        } else {
            map = -1;
        }

        return map;
    }

    @Override
    public int mapBloodPressure(int sbp, int dbp) {
        int map;

        if (sbp < 130 && dbp < 80) {
            map = 1;
        } else if (sbp <= 130 && dbp == 80) {
            map = 2;
        } else if (sbp > 130 && dbp < 100) {
            map = 3;
        } else if (sbp > 150 && dbp > 100) {
            map = 4;
        } else if (sbp > 200) {
            map = 5;
        } else {
            map = 0;
        }
        return map;
    }

    @Override
    public int mapFBS(double fbs) {
        int map;

        if (fbs >= 70 && fbs <= 110) {
            map = 1;
        } else if (fbs >= 111 && fbs <= 140) {
            map = 2;
        } else if (fbs > 140 && fbs <= 200) {
            map = 3;
        } else if (fbs > 200 && fbs <= 300) {
            map = 4;
        } else if (fbs > 300 && fbs <= 400) {
            map = 5;
        } else {
            map = 0;
        }

        return map;
    }

    @Override
    public int mapCholestrol(double chol) {
        int map;

        if (chol >= 50 && chol <= 149) {
            map = 1;
        } else if (chol >= 150 && chol < 185) {
            map = 2;
        } else if (chol >= 185 && chol < 200) {
            map = 3;
        } else if (chol >= 200 && chol < 250) {
            map = 4;
        } else if (chol >= 250 && chol < 500) {
            map = 5;
        } else {
            map = 0;
        }
        return map;
    }

    @Override
    public int mapHDL(double hdl) {
        int map;

        if (hdl >= 0 && hdl <= 39) {
            map = 5;
        } else if (hdl >= 40 && hdl < 60) {
            map = 4;
        } else if (hdl >= 60 && hdl < 75) {
            map = 3;
        } else if (hdl >= 75 && hdl < 100) {
            map = 2;
        } else if (hdl >= 100 && hdl <= 200) {
            map = 1;
        } else {
            map = 0;
        }

        return map;
    }

    @Override
    public int mapLDL(double ldl) {
        int map;

        if (ldl >= 0 && ldl <= 99) {
            map = 1;
        } else if (ldl >= 100 && ldl <= 129) {
            map = 2;
        } else if (ldl >= 130 && ldl <= 159) {
            map = 3;
        } else if (ldl >= 160 && ldl <= 189) {
            map = 4;
        } else if (ldl >= 190 && ldl <= 500) {
            map = 5;
        } else {
            map = 0;
        }
        return map;
    }

    @Override
    public int mapTG(double tg) {
        int map;

        if (tg >= 0 && tg <= 149) {
            map = 1;
        } else if (tg >= 150 && tg <= 179) {
            map = 2;
        } else if (tg >= 180 && tg <= 199) {
            map = 3;
        } else if (tg >= 200 && tg <= 499) {
            map = 4;
        } else if (tg >= 500 && tg <= 1000) {
            map = 5;
        } else {
            map = 0;
        }
        return map;
    }

    @Override
    public int mapHB1AC(double hba1c) {
        int map;

        if (hba1c >= 4 && hba1c <= 6) {
            map = 1;
        } else if (hba1c >= 6.1 && hba1c <= 7) {
            map = 2;
        } else if (hba1c >= 7.1 && hba1c <= 8) {
            map = 3;
        } else if (hba1c >= 8.1 && hba1c <= 9) {
            map = 4;
        } else if (hba1c >= 9.1 && hba1c <= 20) {
            map = 5;
        } else {
            map = 0;
        }
        return map;
    }

    public char convertGender(int gender) {
        if (gender == 1) {
            return 'M';
        } else if (gender == 2) {
            return 'F';
        } else {
            return 'X';
        }
    }

    public int getTotal() {
        return mapBMI(getBMI()) + mapBloodPressure(getSbp(), getDbp()) + mapFBS(getFbs()) + mapCholestrol(getChol())
                + mapHDL(getHdl())
                + mapLDL(getLdl()) + mapTG(getTg()) + mapHB1AC(getHba1c());
    }

    @Override
    public String toString() {
        return getPid() + " " + getAge() + " " + convertGender(getGender()) + " " + mapBMI(getBMI()) + " "
                + mapBloodPressure(getSbp(), getDbp())
                + " " + mapFBS(getFbs()) + " " + mapCholestrol(getChol()) + " " + mapHDL(getHdl()) + " "
                + mapLDL(getLdl()) + " " + mapTG(getTg())
                + " " + mapHB1AC(getHba1c()) + " " + getTotal();
    }

    @Override
    public int compareTo(MedicalMapper o) {
        if (this.getTotal() == o.getTotal())
            return 0;
        else if (this.getTotal() > o.getTotal())
            return 1;
        else
            return -1;
    }
}
