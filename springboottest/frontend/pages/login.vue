<template>
  <v-card
    class="mx-auto"
    max-width="344"
    title="Login"
  >
    <v-container>
      <v-text-field
        v-model="first"
        color="primary"
        label="User name"
        variant="underlined"
        clearable
      ></v-text-field>

      <v-text-field
        type="password"
        v-model="password"
        color="primary"
        label="Password"
        placeholder="Enter your password"
        variant="underlined"
        clearable
      ></v-text-field>
    </v-container>

    <v-divider></v-divider>

    <v-card-actions>
      <v-spacer></v-spacer>

      <v-btn color="success">
        Login

        <v-icon icon="mdi-chevron-right" end></v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>
<script>
  export default {
    data: () => ({
      username: null,
      password: null
    })
  }
</script>