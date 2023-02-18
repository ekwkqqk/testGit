<template>
  <v-table>
    <thead>
      <tr>
        <th class="text-left">다국어</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>{{ $t('sunDay') }}</td>
      </tr>
    </tbody>
    <v-btn color="primary" @click="changeLanguage('ko')">KO</v-btn>
    <v-btn color="primary" @click="changeLanguage('en')">EN</v-btn>
  </v-table>
</template>

<script>
export default {
  name: 'Index',
  computed: {},
  methods: {
    changeLanguage (lang) {
      this.$i18n.setLocale(lang)
    }
  }
}
</script>

<style>
.mt-1 {
  margin-top: 0.5rem;
}

.container {
  margin: 0 auto;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.table {
  min-width: 300px;
  margin: 0 auto;
}

th,
td {
  width: 50%;
  height: 40px;
  line-height: 40px;
}

.links {
  padding-top: 15px;
}
</style>
