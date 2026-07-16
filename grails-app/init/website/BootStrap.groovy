package website

class BootStrap {

    def init = {
        Role.withTransaction {
            if (!Role.count()) {
                def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
                def userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)

                def admin = new User(username: 'admin', password: 'admin123').save(failOnError: true)
                def user = new User(username: 'user', password: 'user123').save(failOnError: true)

                UserRole.create(admin, adminRole)
                UserRole.create(admin, userRole)
                UserRole.create(user, userRole, true)
            }
        }
    }

    def destroy = {
    }

}
