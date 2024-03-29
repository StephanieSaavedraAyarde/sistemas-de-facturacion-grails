package proyecto

class Member {

    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    Boolean isActive = true

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
    }

    def beforeInsert (){
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate(){
        this.password = this.password.encodeAsMD5()
    }

    static mapping = {
        version(false)
    }

}
