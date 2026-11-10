package org.example.bai_tap2.enity;



import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
public class HealthDeclaration {
    @NotBlank(message = "Vui lòng nhập họ tên")
    private String fullName;
    @NotNull(message = "Vui lòng nhập năm sinh")
    @Min(value = 1900, message = "Năm sinh không hợp lệ")
    @Max(value = 2026, message = "Năm sinh không hợp lệ")
    private Integer birthYear;
    @NotBlank(message = "Vui lòng chọn giới tính")
    private String gender;
    @NotBlank(message = "Vui lòng chọn quốc tịch")
    private String nationality;
    @NotBlank(message = "Vui lòng nhập số CMND/CCCD")
    private String identityNumber;
    @NotBlank(message = "Vui lòng chọn phương tiện")
    private String travelType;
    private String vehicleNumber;
    private String seatNumber;
    @NotNull(message = "Vui lòng chọn ngày khởi hành")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Phải là ngày của quá khứ")
    private LocalDate departureDate;
    @NotNull(message = "Vui lòng chọn ngày kết thúc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Phải là ngày của quá khứ")
    private LocalDate returnDate;
    @NotBlank(message = "Vui lòng chọn tỉnh/thành")
    private String province;
    @NotBlank(message = "Vui lòng chọn quận/huyện")
    private String district;
    @NotBlank(message = "Vui lòng chọn phường/xã")
    private String ward;
    @NotBlank(message = "Vui lòng nhập địa chỉ")
    private String address;
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    private String phone;
    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotNull(message = "Vui lòng trả lời triệu chứng sốt")
    private Boolean fever;
    @NotNull(message = "Vui lòng trả lời triệu chứng ho")
    private Boolean cough;
    @NotNull(message = "Vui lòng trả lời triệu chứng khó thở")
    private Boolean difficultyBreathing;
    @NotNull(message = "Vui lòng trả lời triệu chứng đau họng")
    private Boolean soreThroat;
    @NotNull(message = "Vui lòng trả lời triệu chứng nôn/buồn nôn")
    private Boolean nausea;
    @NotNull(message = "Vui lòng trả lời triệu chứng tiêu chảy")
    private Boolean diarrhea;
    @NotNull(message = "Vui lòng trả lời triệu chứng xuất huyết ngoài da")
    private Boolean skinHemorrhage;
    @NotNull(message = "Vui lòng trả lời triệu chứng nổi ban ngoài da")
    private Boolean skinRash;
    @NotNull(message = "Vui lòng trả lời câu hỏi tiếp xúc động vật")
    private Boolean contactWithAnimals;
    @NotNull(message = "Vui lòng trả lời câu hỏi tiếp xúc người mắc bệnh")
    private Boolean contactWithInfectedPerson;
    @NotNull(message = "Vui lòng trả lời câu hỏi đến vùng dịch")
    private Boolean visitedEpidemicArea;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String fullName, Integer birthYear, String gender, String nationality, String identityNumber, String travelType, String vehicleNumber, String seatNumber, LocalDate departureDate, LocalDate returnDate, String province, String district, String ward, String address, String phone, String email, Boolean fever, Boolean cough, Boolean difficultyBreathing, Boolean soreThroat, Boolean nausea, Boolean diarrhea, Boolean skinHemorrhage, Boolean skinRash, Boolean contactWithAnimals, Boolean contactWithInfectedPerson, Boolean visitedEpidemicArea) {
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.travelType = travelType;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.difficultyBreathing = difficultyBreathing;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.contactWithAnimals = contactWithAnimals;
        this.contactWithInfectedPerson = contactWithInfectedPerson;
        this.visitedEpidemicArea = visitedEpidemicArea;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getDifficultyBreathing() {
        return difficultyBreathing;
    }

    public void setDifficultyBreathing(Boolean difficultyBreathing) {
        this.difficultyBreathing = difficultyBreathing;
    }

    public Boolean getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(Boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public Boolean getSkinRash() {
        return skinRash;
    }

    public void setSkinRash(Boolean skinRash) {
        this.skinRash = skinRash;
    }

    public Boolean getContactWithAnimals() {
        return contactWithAnimals;
    }

    public void setContactWithAnimals(Boolean contactWithAnimals) {
        this.contactWithAnimals = contactWithAnimals;
    }

    public Boolean getContactWithInfectedPerson() {
        return contactWithInfectedPerson;
    }

    public void setContactWithInfectedPerson(Boolean contactWithInfectedPerson) {
        this.contactWithInfectedPerson = contactWithInfectedPerson;
    }

    public Boolean getVisitedEpidemicArea() {
        return visitedEpidemicArea;
    }

    public void setVisitedEpidemicArea(Boolean visitedEpidemicArea) {
        this.visitedEpidemicArea = visitedEpidemicArea;
    }
}
