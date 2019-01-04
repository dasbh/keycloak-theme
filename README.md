# keycloak-theme
Custom theme for Keycloak

### Enable auth for WildFly app server hosting keycloak, so that we can deploy our custom extensions using gradle plugin

```
$ cd  /opt/jboss/keycloak/bin
$ ./add-user.sh -u admin -p admin -r ManagementRealm
$ ./jboss-cli.sh --connect --controller=localhost:10090
[standalone@localhost:10090 /] security enable-http-auth-management

```

