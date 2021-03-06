# Magic Link authenticator for Keycloak

Allows users to authenticate through a link sent to their email address instead of using a password.

Screencast available here: https://youtu.be/oyUsI3QgEq8

## Usage

1. Deploy to Keycloak:

    ./gradlew :magic-link:deploy

2. Configure SMTP server for realm

3. Configure realm authentication flow

   * Create copy of Browser flow
   * Delete "Username Password Form" and "OTP Form" executors
   * Click on Actions next to "Copy Of Browser Forms" and click "Add execution"
   * Add "Magic Link"
   * Set requirement "Required" on "Magic Link" executor
   * Click on bindings and switch "Browser flow" to "Copy of browser flow" 